
//front
public class Front extends Move{
	
	public Front() {
		
	}

	public String toString() {
		return "F ";
	}
	
	public void execute(Cube cube) {
		//update the front face
		char temp = cube.permutation[8];
		cube.permutation[8] = cube.permutation[11];
		cube.permutation[11] = cube.permutation[10];
		cube.permutation[10] = cube.permutation[9];
		cube.permutation[9] = temp;
		
		//update the other faces
		char tempLeft = cube.permutation[3];
		cube.permutation[3] = cube.permutation[6];
		cube.permutation[6] = cube.permutation[21];
		cube.permutation[21] = cube.permutation[12];
		cube.permutation[12] = tempLeft;
		
		char tempRight = cube.permutation[2];
		cube.permutation[2] = cube.permutation[5];
		cube.permutation[5] = cube.permutation[20];
		cube.permutation[20] = cube.permutation[15];
		cube.permutation[15] = tempRight;
	}
}