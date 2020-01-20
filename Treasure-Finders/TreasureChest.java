import java.awt.*;
import javax.imageio.ImageIO;
public class TreasureChest extends Item implements Thing
{
	private Image img;
    public TreasureChest()
    {
    	super(1);
    }
    public TreasureChest(int a)
    {
    	super(a);
    }
	public void draw(Graphics window, int x, int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource("treasurechest.png"));
    		window.drawImage(img,x,y,45,45,null);
    	}catch(Exception e){
    		window.setColor(Color.RED);
    		window.fillRect(x+3, y+10, 45-6, 45-16);
    		window.setColor(Color.YELLOW);
    		window.drawRect(x+2, y+9, 45-4, 45-14);
    		window.drawRect(x+3, y+10, 45-6, 45-16);
    		window.drawLine(x+3, y+19, x+41, y+19);
    		window.drawLine(x+3, y+20, x+41, y+20);
    		window.fillOval(x+20, y+14, 4, 4);
    		//window.setColor(Color.BLACK);
    		//window.drawString("Treasure", x, y+35);
    	}
    }
	
	public void draw(Graphics window, int scale, int x, int y)
    {
		scale--;
    	try{
    		img = ImageIO.read(getClass().getResource("treasurechest.png"));
    		window.drawImage(img,x,y,scale,scale,null);
    	}catch(Exception e){
    		window.setColor(Color.RED);
    		window.fillRect(x+3*scale/45, y+10*scale/45, scale-6*scale/45, scale-16*scale/45);
    		window.setColor(Color.YELLOW);
    		window.drawRect(x+2*scale/45, y+9*scale/45,  scale-4*scale/45, scale-14*scale/45);
    		window.drawRect(x+3*scale/45, y+10*scale/45, scale-6*scale/45, scale-16*scale/45);
    		window.drawLine(x+3*scale/45, y+19*scale/45, x+41*scale/45, y+19*scale/45);
    		window.drawLine(x+3*scale/45, y+20*scale/45, x+41*scale/45, y+20*scale/45);
    		window.fillOval(x+20*scale/45, y+14*scale/45, 4*scale/45, 4*scale/45);
    		//window.setColor(Color.BLACK);
    		//window.drawString("Treasure", x, y+scale-10);
    	}

    }
	
    public String getType()
    {
    	return "TreasureChest";
    }

}