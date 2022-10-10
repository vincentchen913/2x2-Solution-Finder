//right inverted
public class RightInverted extends Move{
		
	public RightInverted() {
			
	}
		
	public String toString() {
			return "R'";
	}
	
	public void execute(Cube cube) {
		//update the right face
		char temp = cube.permutation[12];
		cube.permutation[12] = cube.permutation[13];
		cube.permutation[13] = cube.permutation[14];
		cube.permutation[14] = cube.permutation[15];
		cube.permutation[15] = temp;
		
		//update the other faces
		char tempUp = cube.permutation[9];
		cube.permutation[9] = cube.permutation[1];
		cube.permutation[1] = cube.permutation[19];
		cube.permutation[19] = cube.permutation[21];
		cube.permutation[21] = tempUp;
		
		char tempDown = cube.permutation[10];
		cube.permutation[10] = cube.permutation[2];
		cube.permutation[2] = cube.permutation[16];
		cube.permutation[16] = cube.permutation[22];
		cube.permutation[22] = tempDown;
	}
}