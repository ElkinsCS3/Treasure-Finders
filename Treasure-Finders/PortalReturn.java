import static java.lang.System.out;

import java.awt.*;

import javax.imageio.ImageIO;
public class PortalReturn implements Thing
{
	private int portalNum;
	private Position nextPos;
	private Image img;
	private boolean imgFound;

    public PortalReturn()
    {
    	portalNum = 1;
    	nextPos = new Position(0,0);
    }
    public PortalReturn(int num, Position pos)
    {
    		imgFound = false;
    	portalNum = num;
    	nextPos = pos;
    }
    public String getType()
    {
    	return "PortalReturn";
    }
    public int getPortalNum()
    {
    	return portalNum;
    }
    public Position getNextPos()
    {
    	return nextPos;
    }
    public void draw(Graphics window, int x, int y)
    {
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
		window.setColor(Color.GREEN);
		window.fillOval(x,y,45,45);
		window.setColor(Color.BLACK);
	 	window.drawString("Return", x+3, y+27);
    }

    public void draw(Graphics window, int scale, int x, int y)
    {
		window.setFont(new Font("TAHOMA",Font.BOLD,12));
    	scale--;
    	if(imgFound)
    	{
			window.drawImage(img,x,y,scale,scale,null);
    	}
    	else
    	{
    		window.setColor(Color.GREEN);
    		window.fillOval(x,y,scale,scale);
    		window.setColor(Color.BLACK);
   		 	window.drawString("Return", x+3*scale/45, y+27*scale/45);
    	}

    }

}