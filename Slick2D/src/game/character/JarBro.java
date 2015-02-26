package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class JarBro extends aiCharacter {
	
	//use these for the finite state machine!
	public boolean seeking;
	public boolean running;
	public boolean idle;
	//Not a lot to see here - basic ai is in aiCharacter, and multiple characters haven't
	//been implemented yet, so there's no need to change something here. may add unique behavior in the future.
	public JarBro(float x, float y) throws SlickException {
		super(x, y);
		sprite = new Image("testdata/magicpot.png");
		//width = 27
		//height = 45
		stateTransition();
		
	}
	public String getState(String State){
		String returnedState = "Idle";
		switch (State) {
		case "Fleeing":
			returnedState = "Flee!";
			//Have the jarbro flee from the character!
			break;
		case "Seeking":
			returnedState = "Seek!";
			//Have the jarbro flee from the character..
			break;
		case "Idle":
			returnedState = "chill out.";
			//have the jarbro sit still.
			break;
		}
		return returnedState;
	}
	
	public void stateTransition(){
		//if - player has moved away for 5000 milliseconds
		//idle
		
		// if - idled for 10000 milliseconds
		//seek!
		
		//if - player moving towards jarbro
		//Flee!
		
		//return state.
	}
	
}
