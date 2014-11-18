package map;
 
import game.character.Character;
import game.character.Player;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

import tiles.Tile;
import controller.MouseAndKeyBoardControls;

public class Map extends BasicGameState {
	private Tile[][] tileArray;
    private TiledMap map;
    public String name;
    //a list of all characters present somewhere on this map
    private ArrayList<Character> characters;
    private Player player; 
    public  MouseAndKeyBoardControls playerControls;
    
    public Map(String title){
    	name = title;
    }
    
    public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
    	map = new TiledMap("testdata/levels/hope.tmx");
    	characters = new ArrayList<Character>();
    	player = new Player(128,405);
        addCharacter(player);
        playerControls = new MouseAndKeyBoardControls(player);
    }

    public void loadTiledMap(){
    	tileArray = new Tile[map.getWidth()][map.getHeight()];
    	// gets index layer of the collision layer made in Tiled.
    	int layerIndex = map.getLayerIndex("CollisionLayer");
    	for(int i = 0; i < map.getWidth(); i++){
    		for(int j = 0; j < map.getHeight(); j++){
    		// waht deos switch do	
    		}
    	}
    }
    
    public void addCharacter(Character c){
        characters.add(c);
    }
 
    public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException {
    	if(player.isJumping()){
    		player.jump(delta);
    	}
    	playerControls.handleInput(container.getInput(), delta);
    }
    
    @Override
    public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
    	map.render(0, 0, 0, 0, 32, 18);
    	for(Character c : characters){
    		 c.render();
        }
    }
    
    public int getID() {
        //this is the id for changing states
        return 1;
    }
 
}