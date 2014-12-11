package game.character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import org.newdawn.slick.SlickException;

public class aiCharacter extends Character  {
	//true is right, false is left.
	protected boolean direction = true;
	protected boolean isMoving = false;
	protected int inertia = 65;
	int pause = 5000;
	public aiCharacter(float x, float y) throws SlickException {
		super(x, y);
		new Timer(pause, checkmove).start();
		new Timer(pause-3000, checkdirection).start();
	
		
	}
	public void move(int delta) {
		 if (isMoving = true){
			 
		 }
	}
	
    public void movering() {
    	
    	int changeMove = (int) (100*Math.random());
    	if (changeMove >= inertia){
    		isMoving = !isMoving;
    	}
    }
    public void direction() {
    	int changeDirection = (int) (100*Math.random());
    	if (changeDirection >= inertia/2){
    		direction = !direction;
    	}
    }
    ActionListener checkmove = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            movering();
        }
    };
    ActionListener checkdirection = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            movering();
        }
    };
}
