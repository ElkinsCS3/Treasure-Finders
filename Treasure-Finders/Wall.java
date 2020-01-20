import java.awt.*;
public class Wall implements Thing
{
	private Color[][] wallText;
	
	public Wall()
    {
    }
	
    public Wall(Color[][] tx)
    {
    	setWallText();
    }
    
    public void draw(Graphics window,int x,int y)
    {
    	if(wallText!=null)
    	{
	    	for(int r=0;r<wallText.length;r++)
	    	{
	    		for(int c=0;c<wallText.length;c++)
	    		{
	    			window.setColor(wallText[r][c]);
	    			window.fillRect(x+r*5,y+c*5,5,5);
	    		}
	    	}
    	}
	    else
	    {
	    	window.setColor(new Color(100,100,100));
    		window.fillRect(x,y,45,45);
	    }
    }
    
    public void draw(Graphics window, int scale, int x, int y)
    {
	    window.setColor(new Color(100,100,100));
    	window.fillRect(x,y,scale-1,scale-1);
    	
    	if(wallText!=null)
    	{
	    	for(int r=0;r<wallText.length;r++)
	    	{
	    		for(int c=0;c<wallText.length;c++)
	    		{
	    			window.setColor(wallText[r][c]);
	    			window.fillRect(x+r*(5*scale/45),y+c*(5*scale/45),5*scale/45,5*scale/45);
	    		}
	    	}
    	}
    }

	public void setWallText()
	{
		wallText = new Color[9][9];
		for(int r=0;r<9;r++)
    	{
    		for(int c=0;c<9;c++)
    		{
    			int num = (int)(Math.random()*30);
    			wallText[r][c]=new Color(100+num,100+num,100+num);
    		}
    	}
	}
	
    public String getType()
    {
    	return "Wall";
    }
}