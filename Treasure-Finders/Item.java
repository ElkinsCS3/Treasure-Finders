import java.awt.*;
public class Item implements Thing
{
	protected int amount;
	
    public Item(int a)
    {
    	amount = a;
    }
    
    public int getAmount()
    {
    	return amount;
    }
    
    public void setAmount(int a)
    {
    	amount = a;
    }
    
    public void draw(Graphics window, int x, int y)
    {
    	draw(window, 45, x, y);
    }
    
    public void draw(Graphics window, int scale, int x, int y)
    {
    	window.setColor(Color.LIGHT_GRAY);
    	window.fillOval(x, y, scale, scale);
    	window.setColor(Color.BLACK);
    	window.drawString("Item", x+2*scale/45, y+15*scale/45);
    }
    
    public String getType()
    {
    	return "Item";
    }
}