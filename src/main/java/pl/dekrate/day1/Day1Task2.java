package pl.dekrate.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Day1Task2 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Day1Task1.class.getResource("/input.txt")).openStream()))) {
			List<NumberPair> pairs = br.lines().map(line -> {
				String[] parts = line.split(" {3}");
				return new NumberPair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			}).toList();

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


