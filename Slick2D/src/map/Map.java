package map;
 
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
 
public class Map extends BasicGameState {
 
    Map  level;
    String startinglevel;
    private TiledMap map;
 
    public Map(String startingLevel){
        this.startinglevel = startingLevel;
    }
 
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
    	level = new Map(startinglevel);
    	map = new TiledMap("testdata/levels/level_0.tmx", "testdata/data/img");
  
    }
 
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
 
    }
 
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
        map.render(0, 0);
    }
 
    //this method is overriden from basicgamestate and will trigger once you press any key on your keyboard
    public void keyPressed(int key, char code){
        //if the key is escape, close our application
        if(key == Input.KEY_ESCAPE){
            System.exit(0);
        }
    }
 
    public int getID() {
        //this is the id for changing states
        return 1;
    }
 
}