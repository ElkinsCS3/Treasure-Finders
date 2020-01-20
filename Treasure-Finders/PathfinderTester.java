
import static java.lang.System.*;
public class PathfinderTester
{

	public static void main(String[] args)
	{
		char[][] mat1 =	{{'W','W','W','W','W','W'},
						 {'W',' ',' ',' ',' ','W'},
						 {'W','W','D',' ',' ','W'},
						 {'W','E','B',' ',' ','W'},
						 {'W',' ',' ',' ',' ','W'},
						 {'W',' ',' ',' ',' ','W'},
						 {'W',' ',' ',' ',' ','W'},
						 {'W',' ',' ',' ',' ','W'},
						 {'W','W','W','W','W','W'}};
		String path = "";

		path = Pathfinder.findPath(mat1,1,1,4,1);
		out.println(path);
	}
}
