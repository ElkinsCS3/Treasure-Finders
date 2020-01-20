import java.util.*;
public class Inventory
{
	private Item[][] inventory;
	private int numOfItems;

	public Inventory(int r, int c)
	{
		inventory = new Item[r][c];
		numOfItems = 0;
	}

	public boolean add(Item item, int amount)
	{
		while(amount-->0)
		{
			for(int r = 0; r < inventory.length; r++)
			{
				for(int c = 0; c < inventory[0].length; c++)
				{
					if(inventory[r][c] == null)
					{
						inventory[r][c] = item;
						numOfItems++;
						c = inventory[0].length;
						r = inventory.length;
					}
				}
			}

			if(numOfItems >= inventory.length*inventory[0].length)
			{
				System.out.println("Inventory full. " + amount + " items could not be added.");
				return false;
			}
		}
		sort();
		return true;
	}

	public boolean remove(int r, int c)
	{
		if(r>=inventory.length||r<0||c<0||c>=inventory[r].length)
			return false;

		if(inventory[r][c] == null)
			return false;

		inventory[r][c] = null;
		numOfItems--;
		sort();
		return true;
	}

	public Item get(int r, int c)
	{
		if(r>=inventory.length||r<0||c<0||c>=inventory[r].length)
			return null;

		return inventory[r][c];
	}

	public int getNumRows()
	{
		return inventory.length;
	}

	public int getNumCols()
	{
		return inventory[0].length;
	}

	public Position findBrownKey()
	{
		for(int r = 0; r < inventory.length; r++)
		{
			for(int c = 0; c < inventory[r].length; c++)
			{
				if(inventory[r][c] instanceof BrownKey)
					return new Position(r,c);
			}
		}
		return null;
	}
	public Position findRedKey()
	{
		for(int r = 0; r < inventory.length; r++)
		{
			for(int c = 0; c < inventory[r].length; c++)
			{
				if(inventory[r][c] instanceof RedKey)
					return new Position(r,c);
			}
		}
		return null;
	}
	public Position findBlueKey()
	{
		for(int r = 0; r < inventory.length; r++)
		{
			for(int c = 0; c < inventory[r].length; c++)
			{
				if(inventory[r][c] instanceof BlueKey)
					return new Position(r,c);
			}
		}
		return null;
	}
	public Position findPotato()
	{
		for(int r = 0; r < inventory.length; r++)
		{
			for(int c = 0; c < inventory[r].length; c++)
			{
				if(inventory[r][c] instanceof Potato)
					return new Position(r,c);
			}
		}
		return null;
	}
	public void sort()
	{
		int bc=0;
		int sc=0;
		Item[][] tmp = new Item[inventory.length][inventory[0].length];
		ArrayList<Item> p = new ArrayList<Item>();
		ArrayList<Item> k = new ArrayList<Item>();
		ArrayList<Item> k2 = new ArrayList<Item>();
		ArrayList<Item> k3 = new ArrayList<Item>();
		ArrayList<Item> sw = new ArrayList<Item>();
		ArrayList<Item> bsw = new ArrayList<Item>();
		ArrayList<Item> sh = new ArrayList<Item>();
		ArrayList<Item> ds = new ArrayList<Item>();
		ArrayList<Item> a = new ArrayList<Item>();
		ArrayList<Item> t = new ArrayList<Item>();
		for(int r=0;r<inventory.length;r++)
		{
			for(int c=0;c<inventory[0].length;c++)
			{
				if(inventory[r][c] instanceof Potato)
					p.add(inventory[r][c]);
				else if(inventory[r][c] instanceof BossSword)
					bsw.add(inventory[r][c]);
				else if(inventory[r][c] instanceof DiamondShield)
					ds.add(inventory[r][c]);
				else if(inventory[r][c] instanceof Armor)
					a.add(inventory[r][c]);
				else if(inventory[r][c] instanceof Sword)
					sw.add(inventory[r][c]);
				else if(inventory[r][c] instanceof Shield)
					sh.add(inventory[r][c]);
				else if(inventory[r][c] instanceof BrownKey)
					k.add(inventory[r][c]);
				else if(inventory[r][c] instanceof RedKey)
					k2.add(inventory[r][c]);
				else if(inventory[r][c] instanceof BlueKey)
					k3.add(inventory[r][c]);
				else if(inventory[r][c] instanceof teleport)
					t.add(inventory[r][c]);
			}
		}
		int row=0,col=0;
		for(int i=0;i<p.size();i++)
		{
			tmp[row][col]=p.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}

		for(int i=0;i<sw.size()%3;i++)
		{
			tmp[row][col]=sw.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		bc=sw.size()/3;
		for(int i=0;i<bc;i++)
		{
			tmp[row][col]=new BossSword();
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<bsw.size();i++)
		{
			tmp[row][col]=bsw.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<sh.size()%3;i++)
		{
			tmp[row][col]=sh.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		sc=sh.size()/3;
		for(int i=0;i<sc;i++)
		{
			tmp[row][col]=new DiamondShield();
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<ds.size();i++)
		{
			tmp[row][col]=ds.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<a.size();i++)
		{
			tmp[row][col]=a.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<k.size();i++)
		{
			tmp[row][col]=k.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<k2.size();i++)
		{
			tmp[row][col]=k2.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<k3.size();i++)
		{
			tmp[row][col]=k3.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		for(int i=0;i<t.size();i++)
		{
			tmp[row][col]=t.get(i);
			col++;
			if(col>=tmp[0].length)
			{
				col=0;row++;
			}
		}
		inventory=tmp;
	}
	public String toString()
	{
		String output = "";
		for(Item[] row : inventory)
		{
			for(Item item : row)
			{
				if(item == null)
					output += "OO ";
				else
					output += item.getType().substring(0,2) + " ";
			}
			output+= "\n";
		}
		return output;
	}
}
