package gameScreens;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Victoryscreen extends BasicGameState implements KeyListener{
	
	@Override
	public void init(GameContainer game, StateBasedGame arg1) throws SlickException {
		}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
// 		frame.draw();
		g.drawString("The End", 450, 250);
//		animation.draw(0, 0);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 2;
	}

}
