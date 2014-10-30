package map;
 
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
 
public class Map extends BasicGameState {
 
    Map  Map;
   // String startinglevel;
    private TiledMap map;
  //a list of all characters present somewhere on this map
    private ArrayList<Character> characters;
   // public Map(String name){
   //     this.startinglevel = name;
   // }
 
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
    	// Map = new Map(startinglevel);
    	map = new TiledMap("testdata/levels/level_0.tmx", "testdata/data/img");
    	characters = new ArrayList<Character>();
    	
    	//player = new Player(128,416); <- Issues 
        //level.addCharacter(player);	<-
  
    }
    
    public void addCharacter(Character c){
        characters.add(c);
    }
 
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
 
    }
 
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
    	map.render(0, 0, 0, 0, 32, 18);
    	
    	for(Character c : characters){
            //c.render(); <- Doesn't work
        }
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