package startscreen;
//test
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

			
			if(optionNumb == 1){
				g.setColor(Color.magenta);
				g.drawString(optionOne, menuX, menuY);
			}else{
				g.setColor(Color.blue);
				g.drawString(optionOne, menuX, menuY);
			}
			
			if(optionNumb == 2){
				g.setColor(Color.magenta);
				g.drawString(optionTwo, menuX, menuY + menuSpacing);
			}else{
				g.setColor(Color.blue);
				g.drawString(optionTwo, menuX, menuY + menuSpacing);
			}
				
			if(optionNumb == 3){
				g.setColor(Color.magenta);
				g.drawString(optionThree, menuX, menuY + (2 * menuSpacing));
			}else{
				g.setColor(Color.blue);
				g.drawString(optionThree, menuX, menuY + (2 * menuSpacing));
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
			if(optionNumb == 1){
				SlickGame.Game.enterState(1);
			// goes to the map
			}else if(optionNumb == 2){
				System.out.println("credits page?");
			}else if(optionNumb == 3){
				System.exit(0);
			}
		}else if(key == Input.KEY_ESCAPE){
			System.exit(0);
		}else if(key == Input.KEY_DOWN && optionNumb < 3){
			optionNumb++;
		}else if(key == Input.KEY_UP && optionNumb > 1){
			optionNumb--;
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
