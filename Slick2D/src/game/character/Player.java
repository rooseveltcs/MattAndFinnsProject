package game.character;
//test
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import slickgame.SlickGame;
import tiles.SolidTile;
import tiles.AirTile;
import tiles.Tile;

public class Player extends Character {
	protected double thisJumpHeight = 0.0;
	protected boolean falling = false;
	protected double jumpSpeed = 2;
	// Where the player's sprite collided
	/*
	public boolean hitLeft;
	public boolean hitRight;
	public boolean hitAbove;
	public boolean hitBelow;
	*/
	protected int row;
	protected int col;
	
	public Player(float x, float y) throws SlickException{
		super(x,y);
		sprite = new Image("testdata/wizardlady.png");
		height = sprite.getHeight();
        width = sprite.getWidth() + 3;
		row = tileArray.length;
		col = tileArray[0].length;	
	}	
	
	public void rangedAttack(){
		
	}
	
	public void jump(int delta){
		double fallSpeed = thisJumpHeight / 60;
		// set max speed so that u dont fall through the floor	
		if(thisJumpHeight < 50){
			thisJumpHeight++;		
		}
		if(jumping){
			y = (float) y -  (float)(jumpSpeed * (.35 - fallSpeed) * delta);
		}
		if(hitBelow){
		 	thisJumpHeight = 0.0;
		 	setJumping(false);
		}
		if(hitAbove){
			setJumping(false);
			falling = true;
		}
	}
	
	public void fall(int delta, double fallspeed){
		double fallSpeed = thisJumpHeight / 60;	
		if(!hitBelow){
			if(thisJumpHeight < 50){
				thisJumpHeight++;
			}
			y = (float) y -  (float)(jumpSpeed * (.35 - (fallSpeed + (fallspeed))) * delta);	
		}else{
			thisJumpHeight = 0.0;
			falling = false;
		}
	}

	public boolean isFalling(){
		return hitBelow;
	}
	
	public void setJumping(boolean Jumped){
		jumping = Jumped;
	}
	
	public boolean isJumping(){
		return jumping;
	}
	//move left
    public void moveRight(int delta){
    	if(!hitLeft){
    		x = x - (.25f * delta);
    	}
    }	
    //move right	
    public void moveLeft(int delta){
    	if(!hitRight){
    		x = x + (.25f * delta);
    	}
    } 
}

