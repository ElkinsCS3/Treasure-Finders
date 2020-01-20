import static java.lang.System.out;

import java.awt.*;

import javax.imageio.ImageIO;
public class Portal implements Thing
{
	private int portalNum;
	private Position nextPos;
	private Image img;
	private boolean imgFound;

    public Portal()
    {
    	portalNum = 1;
    	nextPos = new Position(0,0);
    }

    public Portal(int num, Position pos)
    {
    	portalNum = num;
    	nextPos = pos;

    }

    public int getPortalNum()
    {
    	return portalNum;
    }

    public Position getNextPos()
    {
    	return nextPos;
    }

    public void draw(Graphics window,int x,int y)
    {
    		window.setColor(Color.BLACK);
    		window.fillOval(x, y, 45, 45);
    }

    public void draw(Graphics window, int scale, int x, int y)
    {
    	scale--;
    		window.setColor(Color.BLACK);
    		window.fillOval(x, y, scale, scale);
    }
    public String getType()
    {
    	return "Portal";
    }

}