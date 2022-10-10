
public class Solution implements Comparable<Solution>{
	
	private int length;
	private String solution;
	
	public Solution() {
		solution = "";
	}
	
	public Solution(Solution other) {
		this.length = other.length;
		this.solution = other.solution;
	}
	
	public void add(String move) {
		solution += move + " ";
		length++;
	}
	
	public void backtrack() {
		solution = solution.substring(0, solution.length() - 3);
		length--;
	}
	
	public int compareTo(Solution otherSolution) {
		return this.length - otherSolution.length;
	}
	
	public String toString() {
		return solution;
	}
}
