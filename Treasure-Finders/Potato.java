import static java.lang.System.out;

import java.awt.*;

import javax.imageio.ImageIO;
public class Potato extends Item implements Thing
{
	private Image img;
	private boolean imgFound;

    public Potato()
    {
    	super(1);
    }

    public Potato(int a)
    {
    	super(a);
    }
	public void draw(Graphics window, int x, int y)
    {
		draw(window, 45, x, y);
    }
    public void draw(Graphics window, int scale, int x, int y)
    {
	    	window.setColor(new Color(186,193,89));
	    	window.fillOval(x+(scale/40),y+(scale/8),scale-2,scale-10);

    }
    public String getType()
    {
    	return "Potato";
    }

}