import java.awt.*;
public interface Thing
{
    public void draw(Graphics window, int y, int x);
    public void draw(Graphics window, int scale, int y, int x);
    public String getType();
}