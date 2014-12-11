package game.character;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import org.newdawn.slick.SlickException;

public class aiCharacter extends Character  {
	
	protected boolean isMoving = false;
	int pause = 5000;
	public aiCharacter(float x, float y) throws SlickException {
		super(x, y);
		new Timer(pause, checkmove).start();
		if(isMoving = true){
			move();
		}
		
	}
	public void move() {
		 
	}
	
    public void movering() {
    	
    	int changeMove = (int) (100*Math.random());
    	if (changeMove >= 65){
    		isMoving = !isMoving;
    	}
    }
    ActionListener checkmove = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
            movering();
        }
    };
}
