import java.awt.*;

import javax.imageio.ImageIO;
public class Armor extends Item implements Thing
{
	private Image img;
    public Armor()
    {
    	super(1);
    }
    public Armor(int a)
    {
    	super(a);
    }
	public void draw(Graphics window,int x,int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource("armor.png"));
    		window.drawImage(img,x,y,45,45,null);
    	}catch(Exception e){
    		window.setColor(Color.RED);
    		window.fillRect(x+12, y+10, 45-24, 27);
    		window.fillRect(x+3, y+15, 6, 17);
    		window.fillRect(x+36, y+15, 6, 17);
    		window.setColor(Color.YELLOW);
    		window.drawRect(x+12, y+10, 45-24, 27);
    		window.drawRect(x+3, y+15, 6, 17);
    		window.drawRect(x+36, y+15, 6, 17);
    		window.fillOval(x+1, y+7, 13, 13);
    		window.fillOval(x+31, y+7, 13, 13);
    		window.drawLine(x+16, y+19, x+16+12, y+19);
    		window.drawLine(x+16, y+24, x+16+12, y+24);
    		window.drawLine(x+16, y+29, x+16+12, y+29);
    		window.setColor(Color.BLACK);
    		//window.drawString("Armor",x+5,y+41);
    	}

    }public void draw(Graphics window, int scale, int x, int y)
    {
    	try{
    		img = ImageIO.read(getClass().getResource("armor.png"));
    		window.drawImage(img,x,y,scale,scale,null);
    	}catch(Exception e){
    		window.setColor(Color.RED);
    		window.fillRect(x+(12*scale/45), y+(10*scale/45), scale-(24*scale/45), (27*scale/45)); //body
    		window.fillRect(x+(3*scale/45), y+(15*scale/45), (6*scale/45), (17*scale/45)); //left arm
    		window.fillRect(x+(36*scale/45), y+(15*scale/45), (6*scale/45), (17*scale/45)); //right arm
    		window.setColor(Color.YELLOW);
    		window.drawRect(x+12*scale/45, y+10*scale/45, scale-24*scale/45, 27*scale/45); //body outline
    		window.drawRect(x+3*scale/45, y+15*scale/45, 6*scale/45, 17*scale/45); //left arm outline
    		window.drawRect(x+36*scale/45, y+15*scale/45, 6*scale/45, 17*scale/45); //right arm outline
    		window.fillOval(x+1*scale/45, y+7*scale/45, 13*scale/45, 13*scale/45); //yellow left circle
    		window.fillOval(x+31*scale/45, y+7*scale/45, 13*scale/45, 13*scale/45); //yellow right circle
    		window.drawLine(x+16*scale/45, y+19*scale/45, x+(16+12)*scale/45, y+19*scale/45); //line in body 1
    		window.drawLine(x+16*scale/45, y+24*scale/45, x+(16+12)*scale/45, y+24*scale/45); //line in body 1
    		window.drawLine(x+16*scale/45, y+29*scale/45, x+(16+12)*scale/45, y+29*scale/45); //line in body 1
    		window.setColor(Color.BLACK);
    		//window.drawString("Armor",x+5,y+41);
    	}

    }
    public String getType()
    {
    	return "Armor";
    }

}