import java.awt.*;
public class Actor implements Thing
{
	protected String name;
	protected Position pos;
	public int currentHealth,maxHealth,defense,damage;
    public Actor(String n, Position p, int def, int dam)
    {
    	name = n;
    	pos = p;
    	maxHealth = 1000;
    	currentHealth = 1000;
    	defense = def;
    	damage = dam;
    }
    public void draw(Graphics window, int x, int y)
    {
    	window.setColor(Color.BLACK);
    	window.fillOval(x+15, y+15, 15, 15);
    	window.setColor(Color.WHITE);
    	window.drawString("Actor", x+5, y+30);
    }

    public void draw(Graphics window, int scale, int x, int y)
    {
    	window.setColor(Color.BLACK);
    	window.fillOval(x+15*scale/45, y+15*scale/45, 15*scale/45, 15*scale/45);
    	window.setColor(Color.WHITE);
    	window.drawString("Actor", x+5*scale/45, y+30*scale/45);
    }

    public String getName()
    {
    	return name;
    }
    public Position getPosition()
    {
    	return pos;
    }
    public int getHealth()
    {
    	return currentHealth;
    }
    public int getMaxHealth()
    {
    	return maxHealth;
    }
    public int getDefense()
    {
    	return defense;
    }
    public int getDamage()
    {
    	return damage;
    }

    public void setName(String n)
    {
    	name = n;
    }
    public void setPos(Position p)
    {
    	pos = p;
    }
    public void setHealth(int h)
    {
    	if(h<0)
    	{
    		currentHealth = 0;
    	}
    	else
    	{
    		currentHealth = h;
    	}
    }
    public void setMaxHealth(int m)
    {
    	maxHealth = m;
    }
    public void setDefense(int d)
    {
    	defense = d;
    }
    public void setDamage(int d)
    {
    	damage = d;
    }

    public String getType()
    {
    	return "Actor";
    }
    public String toString()
    {
    	return name+" "+pos+" "+currentHealth+"/"+maxHealth+" Defense: "+defense;
    }

}