import java.awt.*;
public class Monster implements Thing
{
	protected String name;
	protected Position pos;
	public int currentHealth,maxHealth,defense,damage;
    public Monster(String n,Position p,int de,int da)
    {
    	name = n;
    	defense = de;
    	pos=p;
    	maxHealth=300;
    	currentHealth=300;
    	damage=da;
    }
    public String getName()
    {
    	return name;
    }
    public String getType()
    {
    	return "Monster";
    }
    public void setPos(Position p)
    {
    	pos = p;
    }

    public void draw(Graphics window,int x,int y)
    {
    	draw(window, 45, x, y);
//    	window.setColor(Color.RED);
//    	window.fillOval(x+15,y+15,15,15);
//    	window.drawString("Monster",x+3, y+25);
    }

    public void draw(Graphics window, int scale, int x,int y)
    {
    	window.setColor(Color.RED);
    	window.fillOval(x+15*scale/45,y+15*scale/45,15*scale/45,15*scale/45);
    	window.drawString("Monster",x+3*scale/45, y+25*scale/45);
    }

    public Position getPosition()
    {
    	return pos;
    }
    public int getDefense()
    {
    	return defense;
    }
    public int getDamage()
    {
    	return damage;
    }
    public int getHealth()
    {
    	return currentHealth;
    }
    public int getMaxHealth()
    {
    	return maxHealth;
    }
    protected void setHealth(int h)
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
    public String toString()
    {
    	return name+" "+pos+" "+currentHealth+"/"+maxHealth+" Defense: "+defense;
    }

}