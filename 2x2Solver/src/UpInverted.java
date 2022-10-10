//up inverted
public class UpInverted extends Move{
		
	public UpInverted() {
			
	}
		
	public String toString() {
		return "U'";
	}
	
	public void execute(Cube cube) {
		//update the front face
		char temp = cube.permutation[0];
		cube.permutation[0] = cube.permutation[1];
		cube.permutation[1] = cube.permutation[2];
		cube.permutation[2] = cube.permutation[3];
		cube.permutation[3] = temp;
		
		//update the other faces
		char tempLeft = cube.permutation[8];
		cube.permutation[8] = cube.permutation[4];
		cube.permutation[4] = cube.permutation[16];
		cube.permutation[16] = cube.permutation[12];
		cube.permutation[12] = tempLeft;
		
		char tempRight = cube.permutation[9];
		cube.permutation[9] = cube.permutation[5];
		cube.permutation[5] = cube.permutation[17];
		cube.permutation[17] = cube.permutation[13];
		cube.permutation[13] = tempRight;
	}
}