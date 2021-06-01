package main;

public class ddd {

	public static void main(String[] args) {
		String res_code = "d13";
		
		boolean isNumeric = res_code.chars().allMatch(Character::isDigit);
		System.out.println(isNumeric);

	}

}
