import static java.lang.System.out;

import java.awt.*;

import javax.imageio.ImageIO;
public class Bigpotato extends Item implements Thing
{
	private Image img;
	private boolean imgFound;

    public Bigpotato()
    {
    	super(1);
    }

    public Bigpotato(int a)
    {
    	super(a);
    }
	public void draw(Graphics window, int x, int y)
    {
		draw(window, 45, x, y);
    }
    public void draw(Graphics window, int scale, int x, int y)
    {
	    	window.setColor(Color.RED);
	    	window.fillOval(x+(scale/40),y+(scale/8),scale-2,scale-10);

    }
    public String getType()
    {
    	return "Bigpotato";
    }

}