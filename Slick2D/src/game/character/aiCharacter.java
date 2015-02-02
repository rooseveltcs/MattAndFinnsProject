package game.character;

import java.lang.Math;
import org.newdawn.slick.SlickException;

public class aiCharacter extends Character  {
	//true is right, false is left.
	protected boolean direction = false;
	public boolean isMoving = false;
	//difficulty of changing movement/direction
	protected int inertia = 101;
	//makes it easier to change movement as time goes on
	public int wantToChange = 0;
	//Not implemented
	//public int gottaGoFast = 0;
	public aiCharacter(float x, float y) throws SlickException {
		super(x, y);
	}
	
	//Ai movement logic center
	public void move(int delta) { 
		if (isMoving){
			//changes direction if colliding with a wall. Jumps a short ways away,
			//and is more likely to keep going away from the wall for a short time.
			}if(hitLeft || hitRight){
				direction = !direction;
				wantToChange = -20;
				if(hitRight){
					x -= 25;
				}else if(hitLeft){
					x += 25;
				}
			//movement
			}else if(direction && (!hitLeft)){
					x = x + (.15f * delta);
			}else if(!hitRight){
				x = x - (.15f * delta);
			}
		//decides when to change direction - 50% chance
			int maybeDirection = (int) (100*Math.random());
		if (maybeDirection >= (inertia/2)) {
			changeDirection();
		}
		//falls
		if(!hitBelow){
			y += 2;
		}
	}
	//Direction change logic
	public void changeDirection() {
		//inertia = 101. WantToChange increases each time this test fails, up to 
		int changeDirection = (int) (100*Math.random());
		if (changeDirection >= inertia - wantToChange){
			direction = !direction;
			wantToChange = 0;
			//if(Math.random()*100 >= 90){
			//isMoving = !isMoving;
			//}
		}else{
			if (wantToChange < 50){
			wantToChange +=2;
			}
		}    	
	}
	// Not functional
	/*public void changeMove() {
		int changeMoving = (int) (100*Math.random());
		if (changeMoving >= inertia-gottaGoFast){
			isMoving = !isMoving;
			gottaGoFast = 0;
		}else{
			gottaGoFast += 20*Math.random();
		} 
	}*/
}
