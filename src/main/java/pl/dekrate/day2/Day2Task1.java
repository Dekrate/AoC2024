package pl.dekrate.day2;

import pl.dekrate.day1.Day1Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day2Task1 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(Objects.requireNonNull(Day1Task1.class.getResource("/inputday2.txt")).openStream()))) {
			long amount = br.lines().filter(line -> {
						List<Integer> numbers = Arrays.stream(line.split(" ")).map(Integer::parseInt).toList();
						boolean checkFirstTwo = numbers.get(0) < numbers.get(1);
						for (int i = 0; i < numbers.size() - 1; i++) {
							boolean comparison = numbers.get(i) < numbers.get(i + 1);
							if (comparison != checkFirstTwo) {
								return false;
							}
							int difference = Math.abs(numbers.get(i + 1) - numbers.get(i));
							if (!(difference > 0 && difference < 4)) {
								return false;
							}
						}
						return true;
					}
			).count();
			System.out.println(amount);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
