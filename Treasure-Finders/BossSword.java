import java.awt.*;
import javax.imageio.ImageIO;
public class BossSword extends Item implements Thing
{
	private Image img;
    public BossSword()
    {
    	super(1);
    }
    public BossSword(int a)
    {
    	super(a);
    }
	public void draw(Graphics window,int x,int y)
    {
    	window.setColor(new Color(65,200,200));
    	window.fillRect(x+20, y+5, 45-38, 45-10);
    	window.setColor(Color.GREEN);
    	window.fillRect(x+22, y+8, 45-42, 45-25);
    	window.setColor(Color.BLACK);
    	window.fillRect(x+13, y+28, 45-24, 4);
    }
	public void draw(Graphics window, int scale, int x, int y)
    {
    	window.setColor(new Color(65,200,200));
    	window.fillRect(x+20*scale/45, y+5*scale/45, scale-38*scale/45, scale-10*scale/45);
    	window.setColor(Color.GREEN);
    	window.fillRect(x+22*scale/45, y+8*scale/45, scale-42*scale/45, scale-25*scale/45);
    	window.setColor(Color.BLACK);
    	window.fillRect(x+13*scale/45, y+28*scale/45, scale-24*scale/45, 4*scale/45);
    }
    public String getType()
    {
    	return "BossSword";
    }

}