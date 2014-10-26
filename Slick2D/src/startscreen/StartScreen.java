package startscreen;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StartScreen extends BasicGameState {
	private Image frame; 
	private int menuX = 435;
	private int menuY = 250;
	private int menuSpacing = 75;
	private String optionOne = "Start Game";
	private String optionTwo = "What shld this do?";
	private String optionThree = "Quit";
	
	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
			frame.draw();
			g.setColor(Color.blue);
			
			g.drawString(optionOne, menuX, menuY);
			// score? maybe options? setting?
			g.drawString(optionTwo, menuX, menuY + menuSpacing);
			g.drawString(optionThree, menuX, menuY + (2 * menuSpacing));
		}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
			frame = new Image("testdata/blueframe2.png");	
		
			
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2)
			throws SlickException {
		 // if (input.isMousePressed(0)) {
	       //     sbg.enterState(2); //this will take me to the game.
	     //   }
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
}
