package pl.dekrate.day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Day1Task1 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Day1Task1.class.getResource("/input.txt")).openStream()))) {
			List<NumberPair> pairs = br.lines().map(line -> {
				String[] parts = line.split(" {3}");
				return new NumberPair(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
			}).toList();

			int sum = pairs.stream()
					.sorted(Comparator.comparing(NumberPair::getA).thenComparing(NumberPair::getB))
					.mapToInt(NumberPair::calculateDistance)
					.sum();
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
