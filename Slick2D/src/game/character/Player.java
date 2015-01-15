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
	/*
	public void colliding() {	
		// height 46
		// width 29
		
		//  3 X 4 grid surrounding the character
		
		// FAR RIGHT COLUMN

		//  3 x 3
		//  3 x 2
		if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)) + 32)/32)] instanceof SolidTile){
			hitRight = true;
		}else if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)))/32)] instanceof SolidTile){
			hitRight = true;
		}else{
			hitRight = false;
		}
		
		// MIDDLE COLUMN
		//  2 X 1
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) - 32)/32)] instanceof SolidTile){
			hitAbove = true;
		}
		//  2 X 4
		if(hitLeft){
			if(tileArray[(int)(((x - (x%32)))/32) + 1][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
				hitBelow = true;
				if(!jumping){	
					y = y - (y % 32) + 17;
				}
			}
		}else if(hitRight){
			if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
				hitBelow = true;
				if(!jumping){	
					y = y - (y % 32) + 17;
				}
			}
		}else if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile || tileArray[(int)(((x - (x%32)))/32) + 1][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
			hitBelow = true;
			if(!jumping){	
				y = y - (y % 32) + 17;
			}
		}else{
			hitBelow = false;
		}
			
	
		// FAR LEFT COLUMN
	
		//  1 x 2
		//  1 x 3
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)))/32)] instanceof SolidTile){
			hitLeft = true;
		}else if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) + 32)/32)] instanceof SolidTile){
			hitLeft = true;
		}else{
			hitLeft = false;
		}
	}
	*/
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

