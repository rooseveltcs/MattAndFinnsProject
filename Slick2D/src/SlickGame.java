import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
// http://untamed.wild-refuge.net/rmxpresources.php?characters
public class SlickGame extends BasicGame{
	// private int[] duration = {500,500,500};
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer startScreen = new AppGameContainer(new SlickGame("Setup Test"));
		startScreen.setTargetFrameRate(60);
		startScreen.setDisplayMode(500, 500, false);		
		startScreen.start();
	}
	
	public SlickGame(String title) {
		super(title);

	}
	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		
	}
		
	@Override
	public void init(GameContainer arg0) throws SlickException {
		// Image[] test = {"testdata/thelegend.png"};
		// new Animation(test, duration, false);	
	}
		
	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {

	}
}
