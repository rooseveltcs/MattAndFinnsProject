package gameScreens;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import slickgame.SlickGame;



public class Victoryscreen extends BasicGameState implements KeyListener{

	private Image pointer;	
	private Image frame;
	
	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		pointer = new Image("testdata/star4.png");
		arg0.setMouseCursor(pointer, 10, 10);
		//frame = new Image("testdata/blueframe2.png");
		//needs actual screen to display
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2)
			throws SlickException {
		//frame.draw();
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		
	}

	@Override
	public int getID() {
		return 2;
	}

}
