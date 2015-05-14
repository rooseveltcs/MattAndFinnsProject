package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class JarBro extends aiCharacter {
	
	//use these for the finite state machine!
	public boolean seeking;
	public boolean running;
	public boolean idle;
	private Player player;
	private int storageTime;
	private int distance;
	private int masterTime;
	private int idleDirection = 1;
	//Not a lot to see here - basic ai is in aiCharacter, and multiple characters haven't
	//been implemented yet, so there's no need to change something here. may add unique behavior in the future.
	public JarBro(float x, float y, Player playa) throws SlickException {
		super(x, y);
		sprite = new Image("testdata/magicpot.png");
		// width = 27
		// height = 45
		player = playa;
		masterTime = (int) System.currentTimeMillis();
	}
/*	
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
*/
	@Override
	public void move(int delta){
		stateTransition();
		if(seeking){
			seek(delta);
		}else if(running){
			run(delta);
		}else if(idle){
			idle(delta);
		}
	}
	
	public void seek(int delta){
		if(player.x - this.x < 0){
			this.x = (float) (this.x - (.20 * delta));
		}else{
			this.x = (float) (this.x + (.20 * delta));
		}
	}
	
	public void run(int delta){
		if(player.x - this.x < 0){
			this.x = (float) (this.x + (.20 * delta));
		}else{
			this.x = (float) (this.x - (.20 * delta));
		}
	}
	
	public void idle(int delta){
//		int now = (int)System.currentTimeMillis();
//		if(now % 5000 == 0){
//			idleDirection *= -1;
//		}
//		this.x = (float) (this.x + ((idleDirection * (.20 * delta))));		
	}
	
	public void stateTransition(){
		float distanceFromPlayer = player.x - this.x;
		if(distanceFromPlayer < 0){
			distanceFromPlayer = distanceFromPlayer * -1;
		}

		if(distanceFromPlayer < (32 * 2)){
			seeking = false;
			running = true;
			idle = false;
		}else if(67 < distanceFromPlayer && distanceFromPlayer < (6 * 32)){
			seeking = true;
			running = false;
			idle = false;
		}else{
			seeking = false;
			running = false;
			idle = true;
		}

		//if - hella far away
		//idle
		
		// if - kinda neerish 
		//seek!
		     
		//if - very close
		//Flee!
	}
}
