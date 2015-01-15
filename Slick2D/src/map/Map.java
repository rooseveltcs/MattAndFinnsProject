package map;

import game.character.Character;
import game.character.JarBro;
import game.character.Player;
import game.character.aiCharacter;
import java.util.ArrayList;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import tiles.AirTile;
import tiles.SolidTile;
import tiles.Tile;
import controller.MouseAndKeyBoardControls;

public class Map extends BasicGameState {

	public Tile[][] tileArray;	
	//a list of all characters present somewhere on this map
	private ArrayList<Character> characters;
	private Player player; 
	private String levelName;
	private JarBro jarbro1;
	private JarBro jarbro2;
	private JarBro jarbro3;
	private JarBro jarbro4;
	private JarBro jarbro5;
	private aiCharacter placeHolder;
	// this is here to receive input.
	public  MouseAndKeyBoardControls playerControls;
	protected TiledMap map;
	private Image background;
	Music backgroundMusic;

	public Map(String level) {
		levelName = level;
		// level should be "hope"
		// should use this to reset the window size to fit the map
	}

	public void init(GameContainer container, StateBasedGame sbg) throws SlickException {
		map = new TiledMap("testdata/levels/" + levelName + ".tmx");
		characters = new ArrayList<Character>();
		background = new Image("testdata/data/img/backgrounds/" + map.getMapProperty("background", "cabin.png")); 
		loadTiledMap();
		backgroundMusic = new Music("testdata/Music/jasonMusic.ogg");
		backgroundMusic.loop();
		jarbro1 = new JarBro(400, 400);
		jarbro2 = new JarBro(350, 400);
		jarbro3 = new JarBro(300, 400);
		jarbro4 = new JarBro(370, 400);
		jarbro5 = new JarBro(420, 400);
		addCharacter(jarbro1);
		addCharacter(jarbro2);
		addCharacter(jarbro3);
		addCharacter(jarbro4);
		addCharacter(jarbro5);
		player = new Player(128,400);
		addCharacter(player);
		playerControls = new MouseAndKeyBoardControls(player); 
	}

	public Tile[][] getTiles(){
		return tileArray;
	}

	public void loadTiledMap(){
		tileArray = new Tile[map.getWidth()][map.getHeight()];  
		// gets index layer of the collision layer made in Tiled.
		int layerIndex = map.getLayerIndex("CollisionLayer");
		for(int x = 0; x < map.getWidth(); x++){
			for(int y = 0; y < map.getHeight(); y++){
				int tileID = map.getTileId(x, y, layerIndex);
				Tile tile= null;
				switch(map.getTileProperty(tileID, "tileType", "air")){
				case "solid":
					tile = new SolidTile(x, y);
					break;
				default:
					tile = new AirTile(x, y);
				}
				tileArray[x][y] = tile;
				// System.out.println(map.getTileProperty(tileID, "tileType", "EMPTY"));
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
		if(!player.isFalling() && !player.isJumping()){
		// .5 is a fallspeed that looks and feels nice	
			player.fall(delta, 0.5);
		}
		aiCharacter s = placeHolder;
		for(int i = 0; i < characters.size(); i++){
			if(characters.get(i) instanceof aiCharacter){
				s = (aiCharacter) characters.get(i);
				if(!s.isMoving){
					s.changeMove();
				}else{
					s.move(delta);
				}
			}
		}
		playerControls.handleInput(container.getInput(), delta);
		player.colliding();
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException {
		int x_offset = getXOffset();
		int y_offset = getYOffset();
		renderBackground();
		map.render(-(x_offset%32), -(y_offset%32), x_offset/32, y_offset/32, 32, 18);
		for(Character c : characters){
			c.render(x_offset,y_offset);
		}
	}

	public int getXOffset(){
		int x_offset = 0;
		int halfOfScreen = 500;
		int maxOffsetPostition = (int) (map.getWidth()*32)-halfOfScreen;

		if(player.getX() < halfOfScreen){
			x_offset = 0;
		}else if(player.getX() > maxOffsetPostition){
			x_offset = maxOffsetPostition - halfOfScreen;
		}else{
			x_offset = (int) (player.getX()-halfOfScreen);
		}
		return x_offset;
	}

	public int getYOffset(){
		int y_offset = 0;

		int halfHigh = (int) (375);

		int maxUp = (int) (map.getHeight()*32)-halfHigh;

		if(player.getY() < halfHigh){
			y_offset = 0;
		}else if(player.getY() > maxUp){
			y_offset = maxUp-halfHigh;
		}else{
			y_offset = (int) (player.getY()-halfHigh);
		}
		// stops scrolling along the y, so that i can fix jumping first
		return 0;
		// return y_offset;
	}

	private void renderBackground() {
		background.draw();

	}

	public int getID() {
		//this is the id for changing states
		return 1;
	}

}
