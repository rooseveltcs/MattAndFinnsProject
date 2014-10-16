import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.imageout.ImageOut;
import org.newdawn.slick.Image;
// http://frums.nl/index/showpost/2/
// ^helpful^
public class SlickGame extends BasicGame{
	private Image test;
	public static void main(String[] args) throws SlickException {
		AppGameContainer startScreen = new AppGameContainer(new SlickGame("Setup Test"));
		startScreen.setTargetFrameRate(60);
		startScreen.setDisplayMode(500, 500, false);		
		startScreen.start();
	}
	
	public SlickGame(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		test.draw(100,100);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		test = new Image("testdata/thelegend.png");
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		
	}

}
