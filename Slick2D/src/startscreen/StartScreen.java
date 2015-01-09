package startscreen;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import slickgame.SlickGame;

public class StartScreen extends BasicGameState implements KeyListener{
	
	private Image frame; 
	private Image pointer; 
	private int menuX = 420;
	private int menuY = 210;
	private int menuSpacing = 75;
	private String optionOne =  "	   Start Game";
	private String optionTwo =  "What shld this do?";
	private String optionThree ="	      Quit";
	private int optionNumb =  1;
	
	// change this so it fits level size
	public StartScreen(String Name){
		// System.out.println(Name);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
			frame.draw();
			g.setColor(Color.blue);
			g.drawString(optionOne, menuX, menuY);
			g.drawString(optionTwo, menuX, menuY + menuSpacing);
			g.drawString(optionThree, menuX, menuY + (2 * menuSpacing));
			
			g.setColor(Color.magenta);
			if(optionNumb == 1){
			}
			
		}

	@Override
	public void init(GameContainer gc, StateBasedGame arg1)
			throws SlickException {
			frame = new Image("testdata/blueframe2.png");	
			pointer = new Image("testdata/star4.png");
			gc.setMouseCursor(pointer, 10, 10);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2)
			throws SlickException {
		//  playerControls.handleInput(container.getInput(), delta);
	}

	@Override
	public int getID() {
		return 0;
	}
	
	// we should remove this and let mouse and keyboard handle it instead.
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ENTER){
			System.out.println("enter");
			SlickGame.Game.enterState(1);
			// goes to the map
		}else if(key == Input.KEY_ESCAPE){
			System.exit(0);
		}else if(key == Input.KEY_DOWN){
			optionNumb--;
		}else if(key == Input.KEY_UP){
			optionNumb++;
		}
	}
	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(int key, char c) {
		// TODO Auto-generated method stub
			
	}
}
