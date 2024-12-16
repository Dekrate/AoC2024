package pl.dekrate.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day2Task2 {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				Objects.requireNonNull(Day2Task2.class.getResource("/inputday2.txt")).openStream()))) {
			long total = 0;

			for (String line : br.lines().toList()) {
				List<Integer> numbers = parseLineToNumbers(line);

				if (checkSafety(numbers)) {
					total++;
				} else {
					for (int i = 0; i < numbers.size(); i++) {
						List<Integer> tempNumbers = new ArrayList<>(numbers);
						tempNumbers.remove(i);

						if (checkSafety(tempNumbers)) {
							total++;
							break;
						}
					}
				}
			}

			System.out.println(total);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<Integer> parseLineToNumbers(String line) {
		String[] tokens = line.split(" ");
		List<Integer> numbers = new ArrayList<>();
		for (String token : tokens) {
			numbers.add(Integer.parseInt(token));
		}
		return numbers;
	}

	private static boolean checkSafety(List<Integer> numbers) {
		for (int i = 0; i < numbers.size() - 1; i++) {
			int diff = numbers.get(i + 1) - numbers.get(i);
			if (!(Math.abs(diff) > 0 && Math.abs(diff) < 4)) {
				return false;
			}
		}
		return true;
	}
}
