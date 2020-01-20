import static java.lang.System.*;
import java.util.*;
public class Grid
{
	Thing[][] grid;

	public Grid()
	{
	}

	public Grid(int h, int w)
	{
		grid = new Thing[h][w];
	}

	public void addActor(Thing act, Position pos)
	{
		grid[pos.getRow()][pos.getCol()] = act;
	}

	public void removeActor(int r, int c)
	{
		grid[r][c]=null;
	}

	public int getWidth()
	{
		return grid.length;
	}

	public int getHeight()
	{
		return grid[0].length;
	}

	public Thing get(int r, int c)
	{
		return grid[r][c];
	}

	public void set(Thing[][] g)
	{
		grid = g;
	}

	public void set(Thing obj, int r, int c)
	{
		grid[r][c] = null;
		grid[r][c] = obj;
	}

	public char[][] getCharCopy()
	{
		char[][] temp = new char[getWidth()][getHeight()];
		for(int r = 0; r < grid.length; r++)
		{
			for(int c=0; c<grid[r].length;c++)
			{
				if(grid[r][c] instanceof Monster)
	    			temp[r][c]='M';
				else if(grid[r][c] instanceof FakeWall)
	    			temp[r][c]='F';
				else if(grid[r][c] instanceof BrownKey)
	    			temp[r][c]='J';
				else if(grid[r][c] instanceof RedKey)
	    			temp[r][c]='K';
				else if(grid[r][c] instanceof BlueKey)
	    			temp[r][c]='L';
	    		else if(grid[r][c] instanceof Player)
	    			temp[r][c]='X';
	    		else if(grid[r][c] instanceof Wall)
	    			temp[r][c]='W';
	    		else if(grid[r][c] instanceof BrownDoor)
	    			temp[r][c]='D';
	    		else if(grid[r][c] instanceof RedDoor)
	    			temp[r][c]='B';
	    		else if(grid[r][c] instanceof BlueDoor)
	    			temp[r][c]='E';
	    		else if(grid[r][c] instanceof Portal)
	    			temp[r][c]='P';
	    		else if(grid[r][c] instanceof PortalReturn)
	    			temp[r][c]='R';
	    		else if(grid[r][c] instanceof Potato)
	    			temp[r][c]='Q';
	    		else if(grid[r][c] instanceof Bigpotato)
	    			temp[r][c]='t';
	    		else
	    			temp[r][c]=' ';
			}
		}
		return temp;
	}

	public String toString()
	{
		String output = "";
		for(int r = 0; r < grid.length; r++)
		{
	    	for(int c = 0; c < grid[r].length; c++)
	    	{
	    		if(grid[r][c] instanceof BrownKey)
	    			output+="J ";
	    		else if(grid[r][c] instanceof RedKey)
	    			output+="K ";
	    		else if(grid[r][c] instanceof BlueKey)
	    			output+="L ";
	    		else if(grid[r][c] instanceof Player)
	    			output+="X ";
	    		else if(grid[r][c] instanceof Wall)
	    			output+="W ";
	    		else if(grid[r][c] instanceof BrownDoor)
	    			output+="D ";
	    		else if(grid[r][c] instanceof RedDoor)
	    			output+="B ";
	    		else if(grid[r][c] instanceof BlueDoor)
	    			output+="E ";
	    		else if(grid[r][c] instanceof Portal)
	    			output+="P ";
	    		else if(grid[r][c] instanceof PortalReturn)
	    			output+="R ";
	    		else if(grid[r][c] instanceof Potato)
	    			output+="Q ";
	    		else
	    			output+="  ";
	    	}
	    	output+="\n";
		}
		return output;
	}
}