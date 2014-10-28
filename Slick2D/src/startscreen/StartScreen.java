package startscreen;

import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
// test ?
public class StartScreen extends BasicGameState implements KeyListener{
	private Image frame; 
	private Image pointer; 
	private int menuX = 422;
	private int menuY = 250;
	private int menuSpacing = 75;
	private String optionOne =  "   Start Game";
	private String optionTwo =  "What shld this do?";
	private String optionThree ="      Quit";
	
	@Override
	public void render(GameContainer gc, StateBasedGame arg1, Graphics g)
			throws SlickException {
			frame.draw();
			
			g.setColor(Color.blue);
			
			g.drawString(optionOne, menuX, menuY);
			// score? maybe options? setting?
			g.drawString(optionTwo, menuX, menuY + menuSpacing);
			g.drawString(optionThree, menuX, menuY + (2 * menuSpacing));
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
			
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(key == Input.KEY_ENTER){
			// goes to the map
			System.out.println("enter");
		}else if(key == Input.KEY_ESCAPE){
			System.exit(0);
		}else if(key == Input.KEY_TAB){
			// not sure what this will do yet
			System.out.println("tab");
		}else{
			// nothing happens...
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
