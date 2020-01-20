import java.awt.*;

import javax.imageio.ImageIO;
public class AllKey extends Item implements Thing
{
	private Image img;

    public AllKey()
    {
    	super(1);
    }

    public AllKey(int a)
    {
    	super(a);
    }

	public void draw(Graphics window,int x,int y)
    {
		draw(window, 45, x, y);
    }

	public void draw(Graphics window, int scale, int x, int y)
    {
		window.setColor(Color.CYAN);
		window.fillRect(x+20*scale/45,y+7*scale/45,5*scale/45,22*scale/45);
		window.fillOval(x+15*scale/45,y+19*scale/45,15*scale/45,15*scale/45);
		window.setColor(new Color(214,214,214));
		window.fillOval(x+20*scale/45,y+26*scale/45,5*scale/45,5*scale/45);
    }

    public String getType()
    {
    	return "AllKey";
    }

}