package game.character;

import java.lang.Math;
import org.newdawn.slick.SlickException;

public class aiCharacter extends Character  {
	//true is right, false is left.
	protected boolean direction = false;
	public boolean isMoving = false;
	protected int inertia = 101;
	public int wantToChange = 0;
	public int gottaGoFast = 0;
	public aiCharacter(float x, float y) throws SlickException {
		super(x, y);
	}
	
	public void move(int delta) { 
		if (isMoving){
			if(direction){
				x = x + (.15f * delta);
			}else{
				x = x - (.15f * delta);
			}
		}
		int maybeDirection = (int) (100*Math.random());
		if (maybeDirection >= (inertia/2)) {
			changeDirection();
		}
	}

	public void changeDirection() {

		int changeDirection = (int) (100*Math.random());
		if (changeDirection >= inertia - wantToChange){
			direction = !direction;
			wantToChange = 0;
			if(Math.random()*100 >= 90){
			isMoving = !isMoving;
			}
		}else{
			wantToChange +=2;
			
		}    	
	}
	public void changeMove() {
		int changeMoving = (int) (100*Math.random());
		if (changeMoving >= inertia-gottaGoFast){
			isMoving = !isMoving;
			gottaGoFast = 0;
		}else{
			gottaGoFast += 20*Math.random();
		} 
	}
}
