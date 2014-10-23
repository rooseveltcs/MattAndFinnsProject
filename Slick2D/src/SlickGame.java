import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
// http://untamed.wild-refuge.net/rmxpresources.php?characters

import startscreen.StartScreen;

// this is so i can commit -_-
public class SlickGame extends StateBasedGame{
	public static final int STARTSCREEN = 0;
	public static void main(String[] args) throws SlickException {
		AppGameContainer gameframe = new AppGameContainer(new SlickGame("Setup Test"));
		// startScreen.setTargetFrameRate(60);
		gameframe.setDisplayMode(500, 500, false);		
		gameframe.start();
	}
	
	public SlickGame(String title) {
		super(title);

	}
	
	public void initStatesList(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		addState(new StartScreen());
	}
	
}
