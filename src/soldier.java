import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;

public abstract class soldier {
    protected Rectangle hitbox;
    protected int xloc, yloc;
    
    public soldier(int x, int y){
    makerect();
    xloc = x;
    yloc = y;
}
abstract public void makerect();
abstract public void draw();
}

