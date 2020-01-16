
import org.newdawn.slick.SlickException;

public class base extends structure {

    public base(int x, int y, String s) throws SlickException {
        super(x, y, s);
    }

    @Override
    public void pointvar(int cost, int lvl) {
        loclevel = lvl;
        costcalc(); 
        dept=false;
        
        
        if (lvl == 1 && cost >= 10) {
            var = 5;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }
        if (lvl == 2 && cost >= 250) {
            var = 20;
            strcutlvl++;
            costcalc();
            dept=true;
        }
        if (lvl == 3 && cost >= 2000) {
            var = 100;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }
        if (lvl == 4 && cost >= 50000) {
            var = 250;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
        }

        if (lvl == 5 && cost >= 500000) {
            var = 400;
            strcutlvl++;
            loclevel++;
            costcalc();
            dept=true;
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
            loccost=2000;
        }
        if (loclevel == 4){
            loccost=50000;
        }
        if (loclevel == 5){
            loccost=500000;
        }
    }

}
