import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class human extends soldier {
    private SpriteSheet humspr;
    private Image walk[] = new Image[4];
    private Animation ani;
    public human(int x, int y) throws SlickException {
        super(x, y);
        humspr = new SpriteSheet("data/lof.png",192,192);
        humspr.startUse();
        walk[0] = humspr.getSubImage(0,0);
        walk[1] = humspr.getSubImage(0,1);
        walk[2] = humspr.getSubImage(0,2);
        walk[3] = humspr.getSubImage(1,0);
        
        
        ani = new Animation(walk,100);
        
        humspr.endUse();
        
    }
    
    

    @Override
    public void makerect() {
        
    }

    @Override
    public void draw() {
        ani.start();
        ani.draw(xloc,yloc,hitbox.getWidth(),hitbox.getHeight());
    }
    
}
