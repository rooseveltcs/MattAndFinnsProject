package slickgame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import startscreen.StartScreen;
import map.Map;

//http://untamed.wild-refuge.net/rmxpresources.php?characters


public class SlickGame extends StateBasedGame{
	public static final int STARTSCREEN = 0;
	// private static SlickGame Game;
	public StartScreen Menu = new StartScreen("");
	public static SlickGame Game = new SlickGame("Game");
	public Map level1 = new Map("Map");
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer gameFrame = new AppGameContainer(Game);
		// startScreen.setTargetFrameRate(60);
		gameFrame.setTargetFrameRate(60);
		gameFrame.setDisplayMode(1000, 750, false);		
		gameFrame.start();	
	}
	
	public SlickGame(String title) {
		super(title);
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(Menu);
		addState(level1);	
	}

}
