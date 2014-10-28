
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import startscreen.StartScreen;
import map.Map;

//http://untamed.wild-refuge.net/rmxpresources.php?characters

public class SlickGame extends StateBasedGame{
	public static final int STARTSCREEN = 0;
	public static void main(String[] args) throws SlickException {
		AppGameContainer gameFrame = new AppGameContainer(new SlickGame("Game"));
		// startScreen.setTargetFrameRate(60);
		gameFrame.setDisplayMode(1000, 750, false);		
		gameFrame.start();
	}
	
	public SlickGame(String title) {
		super(title);
		
	}
	
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		addState(new Map());
		addState(new StartScreen());
		enterState(1);

	
	}
}
