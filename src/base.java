
import org.newdawn.slick.SlickException;

public class base extends structure {

    public base(int x, int y, String s) throws SlickException {
        super(x, y, s);
    }

    @Override
    public void pointvar(int cost, int lvl) {
        loclevel = lvl;
        costcalc(); 
        
        
        if (lvl == 1 && cost >= 10) {
            var = 5;
            System.out.println("TRUE");
            strcutlvl++;
            loclevel++;
            costcalc();
        }
        if (lvl == 2 && cost >= 250) {
            var = 20;
            strcutlvl++;
            costcalc();
        }
        if (lvl == 3 && cost >= 1000) {
            var = 100;
            strcutlvl++;
            loclevel++;
            costcalc();
        }
        if (lvl == 4 && cost >= 2500) {
            var = 250;
            strcutlvl++;
            loclevel++;
            costcalc();
        }

        if (lvl == 5 && cost >= 10000) {
            var = 400;
            strcutlvl++;
            loclevel++;
            costcalc();
        }
       

    }
    @Override
    public void costcalc() {
       
        if (loclevel == 1){
            loccost=10;
        }
        if (loclevel == 2){
            loccost=250;
        }
        if (loclevel == 3){
            loccost=1000;
        }
        if (loclevel == 4){
            loccost=2500;
        }
        if (loclevel == 5){
            loccost=10000;
        }
    }

}
