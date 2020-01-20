import java.awt.*;
import javax.imageio.ImageIO;
public class Sword extends Item implements Thing
{
	private Image img;
    public Sword()
    {
    	super(1);
    }
    public Sword(int a)
    {
    	super(a);
    }
	public void draw(Graphics window,int x,int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource("sword.png"));
    		window.drawImage(img,x,y,45,45,null);
    	}catch(Exception e){
    		window.setColor(new Color(174,174,174));
    		window.fillRect(x+20, y+5, 45-38, 45-10);
    		window.setColor(Color.BLACK);
    		window.fillRect(x+13, y+23, 45-24, 7);
    		//window.drawString("Sword", x+5, y+39);
    	}

    }
	public void draw(Graphics window, int scale, int x, int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource("sword.png"));
    		window.drawImage(img,x,y,scale,scale,null);
    	}catch(Exception e){
    		window.setColor(new Color(174,174,174));
    		window.fillRect(x+20*scale/45, y+5*scale/45, scale-38*scale/45, scale-10*scale/45);
    		window.setColor(Color.BLACK);
    		window.fillRect(x+13*scale/45, y+23*scale/45, scale-24*scale/45, 7*scale/45);
    		//window.drawString("Sword", x+5, y+39);
    	}

    }
    public String getType()
    {
    	return "Sword";
    }

}