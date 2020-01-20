import static java.lang.System.*;
import java.util.*;

public class Position implements Locatable 
{
	private int row;
	private int col;

	public Position()
	{
		setPos(0,0);
	}

	public Position(int r, int c)
	{
		setPos(r,c);
	}
	
	public int getRow()
	{
		return row;
	}

	public int getCol()
	{
		return col;
	}

	public void setPos(int r, int c)
	{
		row = r;
		col = c;
	}
	
	public void setRow(int r)
	{
		row = r;
	}
	
	public void setCol(int c)
	{
		col = c;
	}

	public String toString()
	{
		return ""+row+" "+col;
	}
}