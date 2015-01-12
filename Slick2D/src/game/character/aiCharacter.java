package game.character;

import java.lang.Math;
import org.newdawn.slick.SlickException;

//seems as though timers aren't being initialized, or are just not working.

public class aiCharacter extends Character  {
	//true is right, false is left.
	protected boolean direction = false;
	public boolean isMoving = true;
	protected int inertia = 20;
	//int pause = 5000;
	public aiCharacter(float x, float y) throws SlickException {
		super(x, y);
		//new Timer(pause, checkmove).start();
		//new Timer(pause-3000, checkdirection).start();


	}
	public void move(int delta) { 
		if (isMoving){
			if(direction){
				x = x - (.25f * delta);
			}else{
				x = x + (.25f * delta);
			}
		}
		int maybeDirection = (int) (100*Math.random());
		if (maybeDirection >= (inertia/2)) {
			changeMove();
		}
	}

	public boolean changeMove() {

		int changeMove = (int) (100*Math.random());
		if (changeMove >= inertia){
			return !isMoving;
		}else{
			return isMoving;
		}    	
	}
	public void direction() {
		int changeDirection = (int) (100*Math.random());
		if (changeDirection >= inertia/2){
			direction = !direction;
		}
	}
}
