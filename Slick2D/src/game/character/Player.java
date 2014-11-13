package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
	protected Image sprite;
	private double thisJumpHeight = 0;
	
	public Player(float x, float y) throws SlickException{
		super(x,y);
		sprite = new Image("testdata/wizardlady.png");
        	
    }	
		
	public void jump(int delta){
		double jumpSpeed = 2;
		thisJumpHeight++;
		// sixty is the magic number, it just works.
		if(y <= 406.0){
			y = (float) y -  (float)(jumpSpeed * (.35 - thisJumpHeight / 60)) * delta;
		}else{
			System.out.println(y);
			thisJumpHeight = 0;
			y -= 10.667;
		}
	    // System.out.println(y + "delta " + delta + " thisjumpheight " + thisJumpHeight);
	}	
		
    public void moveRight(int delta){
    	x = x - (.25f * delta);
    }	
    	
    public void moveLeft(int delta){
    	x = x + (.25f * delta);
    }   
    	
    public void render(){
    	sprite.draw(x,y);
    }
}

