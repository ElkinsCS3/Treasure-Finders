import static java.lang.System.*;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Boss extends Monster implements Thing
{
	public Boss()
	{
		super("Boss", new Position(0,0), 0, 0);
	}
    public Boss(String n, Position p, int def, int dam)
    {
    	super(n, p, def, dam);
    	currentHealth = 5000;
    	maxHealth = 5000;
    }

    public void draw(Graphics window, int x, int y)
    {
		try{
			Image img = ImageIO.read(getClass().getResource("Boss.png"));
			window.drawImage(img,x,y,90,90,null);
		}
		catch(Exception e){
			window.setColor(Color.RED);
			window.fillOval(x,y,90,90);
		}
		//health bar
		window.setColor(Color.RED);
		window.fillRect(x,y,90,9);
		window.setColor(Color.GREEN);
		window.fillRect(x,y,(int)(((double)currentHealth/(double)maxHealth)*90),9);

    }

    public void draw(Graphics window, int scale, int x, int y)
    {
		try{
			Image img = ImageIO.read(getClass().getResource("Boss.png"));
			window.drawImage(img,x,y,scale*2,scale*2,null);
		}
		catch(Exception e){
			window.setColor(Color.RED);
			window.fillOval(x,y,scale*2,scale*2);
		}

		//health bar
		window.setColor(Color.RED);
		window.fillRect(x,y,scale*2-1,9*scale/45);
		window.setColor(Color.GREEN);
		if(currentHealth == maxHealth) window.fillRect(x, y, scale * 2 , 9*scale/45);
		else window.fillRect(x,y,(int)((((double)currentHealth/(double)maxHealth)*(scale-1))*2.0),9*scale/45);

    }

    public String getType()
    {
    	return "Boss";
    }

    public String toString()
    {
		return super.toString()+" damage: "+damage;
    }
}
