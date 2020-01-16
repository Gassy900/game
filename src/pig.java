
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class pig extends soldier {

    public pig(int x, int y, String s) throws SlickException {
        super(x, y, s);
    }

    @Override
    public void move(Rectangle var) {
         if(hitbox.intersects(var)){
            xloc=xloc;
            isdead=true;
        } else{
           xloc-=1;
           isdead=false;
        }
    }
    
    
}
