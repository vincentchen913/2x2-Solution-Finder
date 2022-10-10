import java.util.ArrayList;
import java.util.Arrays;

public class Cube {
	
	private char[] permutation;
	public final static int NUM_SIDES = 6;
	
	public Cube(String cube) {
		//check if string is valid
		if(isValid(cube)) {
			permutation = new char[24];
			for(int i = 0; i < permutation.length; i++) {
				permutation[i] = cube.charAt(i);
			}
		}else {
			throw new IllegalArgumentException("Cube permutation is not valid.");
		}
	}
	
	public char[] getPermutation() {
		return permutation;
	}
	
	public void setPermutation(final char[] permutation) {
		this.permutation = permutation;
	}
	
	public String toString() {
		return Arrays.toString(permutation);
	}
	
	public Cube(char[] cube) {
		//convert to string
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i < cube.length; i++) {	
			temp.append(cube[i]);
		}
		
		//check if string is valid
		if(isValid(temp.toString())) {
			permutation = new char[24];
			for(int i = 0; i < permutation.length; i++) {
				permutation[i] = temp.toString().charAt(i);
			}
		}else {
			throw new IllegalArgumentException("Cube permutation is not valid.");
		}
	}
	
	public boolean isSolved() {
		ArrayList<Character> colors = getColors();
		for(int i = 0; i < permutation.length; i += 4) {
			char color = permutation[i];
			//check if arraylist contains the color
			if(colors.contains(color)) {
				colors.remove((Object) color);
				for(int j = i + 1; j < i + 4; j++) {
					if(permutation[j] != color) {
						return false;
					}
				}
			}else {
				return false;
			}	
		}
		return true;
	}
	
	private boolean isValid(String permutation) {
		int[] correct = getCorrectLetterInventory();
		//first loop checks if there are any invalid letters
		int[] letterInventory = new int[128];
		for(int i = 0; i < permutation.length(); i++) {
			int currentChar = permutation.charAt(i);
			letterInventory[currentChar]++;
		}
		return Arrays.equals(correct, letterInventory);
	}
	
	private int[] getCorrectLetterInventory(){
		int[] result = new int[128];
		result[114] = 4;
		result[111] = 4;
		result[121] = 4;
		result[103] = 4;
		result[98] = 4;
		result[119] = 4;
		return result;
	}
	private ArrayList<Character> getColors() {
		ArrayList<Character> result = new ArrayList<>();
		result.add('r');
		result.add('o');
		result.add('y');
		result.add('g');
		result.add('b');
		result.add('w');
		
		return result;
	}
}
