import java.awt.*;
import javax.imageio.ImageIO;
public class Shield extends Item implements Thing
{
	private Image img;
    public Shield()
    {
    	super(1);
    }
    public Shield(int a)
    {
    	super(a);
    }
	public void draw(Graphics window,int x,int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource("shield.png"));
    		window.drawImage(img,x,y,45,45,null);
    	}catch(Exception e){
    		window.setColor(Color.BLUE);
    		window.fillRect(x+5, y+5, 45-10, 19);
    		window.fillOval(x+4, y+8, 45-9, 35);
    		window.setColor(Color.CYAN);
    		window.fillRect(x+20, y+10, 45-40, 45-19);
    		window.fillRect(x+10, y+20, 45-20, 45-40);
    		//window.setColor(Color.WHITE);
    		//window.drawString("Shield", x+4, y+28);
    	}

    }
	public void draw(Graphics window, int scale, int x, int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource("shield.png"));
    		window.drawImage(img,x,y,scale,scale,null);
    	}catch(Exception e){
    		window.setColor(Color.BLUE);
    		window.fillRect(x+5*scale/45, y+5*scale/45, scale-10*scale/45, 19*scale/45);
    		window.fillOval(x+4*scale/45, y+8*scale/45, scale-9*scale/45, 35*scale/45);
    		window.setColor(Color.CYAN);
    		window.fillRect(x+20*scale/45, y+10*scale/45, scale-40*scale/45, scale-19*scale/45);
    		window.fillRect(x+10*scale/45, y+20*scale/45, scale-20*scale/45, scale-40*scale/45);
    		//window.setColor(Color.WHITE);
    		//window.drawString("Shield", x+4, y+28);
    	}

    }
    public String getType()
    {
    	return "Shield";
    }

}