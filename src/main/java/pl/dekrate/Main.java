package pl.dekrate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		// otwórz plik input.txt używając try-with-resources
		try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Main.class.getResource("/input.txt")).openStream()))) {
			List<NumberPair> pairs = br.lines().map(line -> {
				String[] parts = line.split(" {3}");
				return new NumberPair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			}).toList();

			int sum = pairs.stream()
					.sorted(Comparator.comparing(NumberPair::getA).thenComparing(NumberPair::getB))
					.mapToInt(NumberPair::calculateDistance)
					.sum();
			System.out.println(pairs.stream()
					.sorted(Comparator.comparing(NumberPair::getA).thenComparing(NumberPair::getB))
					.mapToInt(NumberPair::calculateDistance)
					.sum());

			Map<Integer, Long> bCounts = pairs.stream()
					.map(NumberPair::getB)
					.collect(Collectors.groupingBy(b -> b, Collectors.counting()));

			int sumTask = pairs.stream()
					.mapToInt(pair -> pair.getA() * bCounts.getOrDefault(pair.getA(), 0L).intValue())
					.sum();

			System.out.println(sumTask);




		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}