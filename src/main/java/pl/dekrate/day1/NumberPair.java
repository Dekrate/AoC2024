package pl.dekrate.day1;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class NumberPair {
	private Integer a;
	private Integer b;

	public Integer calculateDistance() {
		return Math.abs(a - b);
	}
}
