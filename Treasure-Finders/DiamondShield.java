import java.awt.*;
import javax.imageio.ImageIO;
public class DiamondShield extends Item implements Thing
{
	private Image img;
    public DiamondShield()
    {
    	super(1);
    }
    public DiamondShield(int a)
    {
    	super(a);
    }
	public void draw(Graphics window,int x,int y)
    {
    		window.setColor(new Color(234,200,0));
    		window.fillRect(x+5, y+5, 35, 19);
    		window.fillOval(x+4, y+8, 36, 35);
    		window.setColor(new Color(65,200,200));
    		window.fillRect(x+10, y+10, 25, 9);
    		window.fillOval(x+9, y+13, 26, 25);
    		window.setColor(Color.YELLOW);
    		window.fillRect(x+20, y+10, 5, 26);
    		window.fillRect(x+10, y+20, 25, 5);

    }
	public void draw(Graphics window, int scale, int x, int y)
    {
    		window.setColor(new Color(234,200,0));
    		window.fillRect(x+5*scale/45, y+5*scale/45, 35*scale/45, 19*scale/45);
    		window.fillOval(x+4*scale/45, y+8*scale/45, 36*scale/45, 35*scale/45);
    		window.setColor(new Color(65,200,200));
    		window.fillRect(x+10*scale/45, y+10*scale/45, 25*scale/45, 9*scale/45);
    		window.fillOval(x+9*scale/45, y+13*scale/45, 26*scale/45, 25*scale/45);
    		window.setColor(Color.YELLOW);
    		window.fillRect(x+20*scale/45, y+10*scale/45, 5*scale/45, 26*scale/45);
    		window.fillRect(x+10*scale/45, y+20*scale/45, 25*scale/45, 5*scale/45);

    }
    public String getType()
    {
    	return "DiamondShield";
    }

}