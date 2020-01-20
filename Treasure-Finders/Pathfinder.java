public class Pathfinder
{
    public static String findPath(char[][] mat, int rx, int cx, int rt, int ct)
	{
		int[][] intMat = convert(mat,rt,ct);
		int[][] intMat2 = convertTwo(mat,rt,ct);
		int[][] intMat3 = convertThree(mat,rt,ct);
		fill(intMat,rx,cx,rt,ct,1);
		fill(intMat2,rx,cx,rt,ct,1);
		fill(intMat3,rx,cx,rt,ct,1);
		String s1 = makeString(intMat,rx,cx,rt,ct);
		String s2 = makeString(intMat2,rx,cx,rt,ct);
		String s3 = makeString(intMat3,rx,cx,rt,ct);
		print(intMat); print(intMat2); print(intMat3);
		if(!s3.equals("!") )
			return s3;
		else if(!s2.equals("!"))
			return s2;
		else
			return s1;

	}

	public static void fill(int[][] mat, int rx, int cx, int rt, int ct, int n)
	{
		if(rx<0||rx>mat.length-1||cx<0||cx>mat[rx].length-1||rt<0||rt>mat.length-1||ct<0||ct>mat[rt].length-1)
			return;
		mat[rx][cx] = n++;
		if(rx-1>=0&&mat[rx-1][cx]==0||mat[rx-1][cx]>n)
			fill(mat,rx-1,cx,rt,ct,n);
		if(cx+1<=mat[rx].length-1&&mat[rx][cx+1]==0||mat[rx][cx+1]>n)
			fill(mat,rx,cx+1,rt,ct,n);
		if(rx+1<=mat.length-1&&mat[rx+1][cx]==0||mat[rx+1][cx]>n)
			fill(mat,rx+1,cx,rt,ct,n);
		if(cx-1>=0&&mat[rx][cx-1]==0||mat[rx][cx-1]>n)
			fill(mat,rx,cx-1,rt,ct,n);
	}

	public static String makeString(int[][] mat, int rx, int cx, int rt, int ct)
	{
		if(rx<0||rx>mat.length-1||cx<0||cx>mat[rx].length-1||rt<0||rt>mat.length-1||ct<0||ct>mat[rt].length-1)
			return "!SOMETHING OUT OF BOUNDS";
		if(mat[rt][ct]==0)
			return "!";
		if(rt==rx&&ct==cx)
			return "";
		String dir = "";
		if(ct-1>=0&&mat[rt][ct-1]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt,ct-1) + "E";
		else if(ct+1<=mat[rt].length-1&&mat[rt][ct+1]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt,ct+1) + "W";
		else if(rt-1>=0&&mat[rt-1][ct]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt-1,ct) + "S";
		else if(rt+1<=mat.length-1&&mat[rt+1][ct]==(mat[rt][ct]-1))
			dir = makeString(mat,rx,cx,rt+1,ct) + "N";
		return dir;
	}

	public static int[][] convert(char[][] mat, int rt, int ct) //makes walls, fake walls, portals, and return portals unwalkable
	{
		int[][] intMat = new int[mat.length][mat[0].length];
		for(int r = 0; r < mat.length; r++)
		{
			for(int c = 0; c < mat[0].length; c++)
			{
				if(mat[r][c]== 'W' || mat[r][c]== 'F' || mat[r][c]== 'P' || mat[r][c]== 'R')
					intMat[r][c] =-1;
				else
					intMat[r][c] = 0;
			}
		}
		if(mat[rt][ct] == 'P' || mat[rt][ct]== 'F' || mat[rt][ct] == 'R' || mat[rt][ct] == 'D' || mat[rt][ct] == 'B' || mat[rt][ct] == 'E' || mat[rt][ct] == 'M')
			intMat[rt][ct] = 0;
		return intMat;
	}

	public static int[][] convertTwo(char[][] mat, int rt, int ct) //makes walls, fake walls, portals, return portals, and monsters unwalkable
	{
		int[][] intMat = new int[mat.length][mat[0].length];
		for(int r = 0; r < mat.length; r++)
		{
			for(int c = 0; c < mat[0].length; c++)
			{
				if(mat[r][c]== 'W' || mat[r][c]== 'F' || mat[r][c]== 'P' || mat[r][c]== 'R' || mat[r][c] == 'M')
					intMat[r][c] =-1;
				else
					intMat[r][c] = 0;
			}
		}
		if(mat[rt][ct] == 'P' || mat[rt][ct]== 'F' || mat[rt][ct] == 'R' || mat[rt][ct] == 'D' || mat[rt][ct] == 'B' || mat[rt][ct] == 'E' || mat[rt][ct] == 'M')
			intMat[rt][ct] = 0;
		return intMat;
	}

	public static int[][] convertThree(char[][] mat, int rt, int ct) //makes walls, fake walls, portals, return portals, doors, and monsters unwalkable
	{
		int[][] intMat = new int[mat.length][mat[0].length];
		for(int r = 0; r < mat.length; r++)
		{
			for(int c = 0; c < mat[0].length; c++)
			{
				if(mat[r][c]== 'W' || mat[r][c]== 'F' || mat[r][c]== 'P' || mat[r][c]== 'R' || mat[r][c] == 'D' || mat[r][c] == 'B' || mat[r][c] == 'E' || mat[r][c] == 'M')
					intMat[r][c] =-1;
				else
					intMat[r][c] = 0;
			}
		}
		if(mat[rt][ct] == 'P' || mat[rt][ct]== 'F' || mat[rt][ct] == 'R' || mat[rt][ct] == 'D' || mat[rt][ct] == 'B' || mat[rt][ct] == 'E' || mat[rt][ct] == 'M')
			intMat[rt][ct] = 0;
		return intMat;
	}

	public static void print(int[][] intMat)
	{
		for(int[] c : intMat)
		{
			for(int i : c)
			{
				if(i>9||i<0)
					System.out.print(i+" ");
				else
					System.out.print(i+"  ");
			}
			System.out.println();
		}
	}
}