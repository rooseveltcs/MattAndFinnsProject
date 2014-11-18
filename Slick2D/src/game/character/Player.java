package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
	protected Image sprite;
	private double thisJumpHeight = 0;
	private boolean jumping;
	
	public Player(float x, float y) throws SlickException{
		super(x,y);
		sprite = new Image("testdata/wizardlady.png");
    }	

	public void jump(int delta){
		double jumpSpeed = 2;
		thisJumpHeight++;		
		// fix this wen actual collision works
		if(y <= 420.0){
			//406.0
			y = (float) y -  (float)(jumpSpeed * (.35 - thisJumpHeight / 60) * delta);
		}else{
			thisJumpHeight = 0;
			setJumping(false);
			// this is the exact offset between where the sprite lands, and the boundary on the if statement
			y -= 10.667;
		}
	}
	
	public void setJumping(boolean Jumped){
		jumping = Jumped;
	}
	
	public boolean isJumping(){
		return jumping;
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

