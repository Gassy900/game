
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;


public class human extends soldier{

    public human(int x, int y, String s) throws SlickException {
        super(x, y, s);
    }
    

    @Override
    public void move(Rectangle var) {
        if(hitbox.intersects(var)){
            ani.stop();
        } else{
           xloc+=1;
        }
    }
    
}