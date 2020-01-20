import java.awt.*;
public class RedDoor implements Thing
{
    public RedDoor()
    {
    }

    public void draw(Graphics window,int x,int y)
    {
    	window.setColor(Color.RED);
    	window.fillRect(x,y,45,45);
    	window.setColor(Color.BLACK);
    	window.drawLine(x+9,y,x+9,y+44);
    	window.drawLine(x+18,y,x+18,y+44);
    	window.drawLine(x+27,y,x+27,y+44);
    	window.drawLine(x+36,y,x+36,y+44);
    }

    public void draw(Graphics window, int scale, int x, int y)
    {
    	scale--;
    	window.setColor(Color.RED);
    	window.fillRect(x,y,scale,scale);
    	window.setColor(Color.BLACK);
    	window.drawLine(x+9*scale/45,y,x+9*scale/45,y+44*scale/45);
    	window.drawLine(x+18*scale/45,y,x+18*scale/45,y+44*scale/45);
    	window.drawLine(x+27*scale/45,y,x+27*scale/45,y+44*scale/45);
    	window.drawLine(x+36*scale/45,y,x+36*scale/45,y+44*scale/45);
    }

    public String getType()
    {
    	return "RedDoor";
    }
}