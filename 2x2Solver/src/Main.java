import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//test cases
//		String demo = "wwwwooooggggrrrrbbbbyyyy";
//		
//		String needR = "wbbwoooogwwgrrrrybbyyggy";
//		String needRi = "wggwoooogyygrrrrwbbwybby";
//		String needF = "wwrrowwoggggyrrybbbbooyy";
//		String needFi = "wwoooyyoggggwrrwbbbbrryy";
//		String needU = "wwwwbbooooggggrrrrbbyyyy";
//		String needUi = "wwwwggoorrggbbrroobbyyyy";
	
		drawDiagram();
		
		System.out.print("Type permutation here: ");
		Scanner sc = new Scanner(System.in);
		String input = sc.next().toLowerCase();
		System.out.println();
		System.out.println("Finding Solutions...");
		System.out.println( );
			
		Cube jim = new Cube(input);
		jim.getPermutation();
		Move[] moves = getMoves();

		ArrayList<Solution> solutions = new ArrayList<>();
		Solution solution = new Solution();
		
		helper(11, moves, jim, solution, 0, solutions);
		
		Collections.sort(solutions);
		if(solutions.isEmpty()) {
			System.out.println("No Solutions Found");
		}else {
			System.out.println("Number of Solutions: "+ solutions.size());
			for(int i = 0; i < solutions.size(); i++) {
				System.out.println(solutions.get(i));
			}	
		}
		sc.close();
	}
	
	public static Move[] getMoves() {
		Move[] result = new Move[6];
		Move R = new Right();
		Move Ri = new RightInverted();
		Move F = new Front();
		Move Fi = new FrontInverted();
		Move U = new Up();
		Move Ui = new UpInverted();
		
		result[0] = R;
		result[1] = Ri;
		result[2] = F;
		result[3] = Fi;
		result[4] = U;
		result[5] = Ui;
		
		return result;
	}
	
	public static void helper(int movesLeft, Move[] moves, Cube cube, Solution solution, int moveIndex, ArrayList<Solution> solutions) {
		if(cube.isSolved()) {
			Solution temp = new Solution(solution);
			solutions.add(temp);
		}else if(movesLeft == 0 || moveIndex == moves.length - 1) {
			//do nothing
		}else {
			for (Move current : moves){
				solution.add(current.toString());
				current.execute(cube);
				helper(movesLeft - 1, moves, cube, solution, moveIndex, solutions);
				current.execute(cube);
				current.execute(cube);
				current.execute(cube);
				solution.backtrack();
				moveIndex++;
			}
		}
	}
	
	public static void drawDiagram() {
		System.out.println("Type out cube permutation as shown by the diagram below.");
		System.out.println("Permutation must be a string with 24 characters (r, o, y, g, b, w)");
		System.out.println("             ___________");
		System.out.println("            |     |     |");
		System.out.println("            |  0  |  1  |");
		System.out.println("            |_____|_____|");
		System.out.println("            |     |     |");
		System.out.println("            |  3  |  2  |");
		System.out.println(" ___________|_____|_____|_______________________");
		System.out.println("|     |     |     |     |     |     |     |     |");
		System.out.println("|  4  |  5  |  8  |  9  |  12 |  13 |  16 |  17 |");
		System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|");
		System.out.println("|     |     |     |     |     |     |     |     |");
		System.out.println("|  7  |  6  |  11 |  10 |  15 |  14 |  19 |  18 |");
		System.out.println("|_____|_____|_____|_____|_____|_____|_____|_____|");
		System.out.println("            |     |     |");
		System.out.println("            |  20 |  21 |");
		System.out.println("            |_____|_____|");
		System.out.println("            |     |     |");
		System.out.println("            |  23 |  22 |");
		System.out.println("            |_____|_____|");
		System.out.println();
	}

}
