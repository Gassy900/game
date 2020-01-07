import org.newdawn.slick.*;

public class test extends BasicGame {

public test (String title) {
super(title);
}

public void init(GameContainer gc) throws SlickException {

}

public void update(GameContainer gc, int i) throws SlickException {

}

public void render(GameContainer gc, Graphics g) throws SlickException {

}

public static void main(String args[]) throws SlickException {
  test game = new test("Testing Game");
  AppGameContainer app = new AppGameContainer(game);
  app.setDisplayMode(800, 600, false);
  app.setShowFPS(false);
  app.setTargetFrameRate(100);
  app.start();
}

}
