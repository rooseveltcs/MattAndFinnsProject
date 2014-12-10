package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import slickgame.SlickGame;
import tiles.SolidTile;
import tiles.AirTile;
import tiles.Tile;

public class Player extends Character {
	protected double thisJumpHeight = 0;
	protected boolean jumping;
	protected Tile[][] tileArray;
	// where the player's sprite collided
	protected boolean hitLeft;
	protected boolean hitRight;
	protected boolean hitAbove;
	protected boolean hitBelow;
	protected int row;
	protected int col;
	
	public Player(float x, float y) throws SlickException{
		super(x,y);
		sprite = new Image("testdata/wizardlady.png");
		height = sprite.getHeight();
        width = sprite.getWidth();
		tileArray = SlickGame.Game.level1.getTiles();
		row = tileArray.length;
		col = tileArray[0].length;	
	}	
	
	public void jump(int delta){
		double jumpSpeed = 2;
		thisJumpHeight++;		
		// fix this  when actual collision works
		if(y <= 350){
			y = (float) y -  (float)(jumpSpeed * (.35 - thisJumpHeight / 60) * delta);
		}else{
			thisJumpHeight = 0;
			setJumping(false);
			// this is the exact offset between where the sprite lands, and the boundary on the if statement
			y -= 10.667;
		}
	}
	/*
	if((int)(x) + width <= tileRightX && (int)(x) + width >= tileLeftX 
			|| (int)(x) <= tileRightX && (int)(x) >= tileLeftX){
		if((int)(y) + height <= tileTopY && (int)(y) + height >= tileBottomY 
				|| (int)(y) <= tileTopY && (int)(y) >= tileBottomY){
	*/
	public void colliding(){	
		// int collidedTimes = 0;

		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				int tileRightX = i*32 + 32;
				int tileLeftX = i*32;
				int tileTopY =  j*32 + 32;
				int tileBottomY = j*32;
				
				// bottom and top collision work fine i think, problem is left and right. 
				// probably secondary if statement
				if(tileArray[i][j] instanceof SolidTile){
					//hit right
					if((int)(x) + width <= tileRightX && (int)(x) + width >= tileLeftX){
						if((int)(y) <= tileTopY && (int)(y) >= tileBottomY){
							System.out.println("ya were hit right");
						}
					}
					//hit left
					if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
						if((int)(y) <= tileTopY && (int)(y) >= tileBottomY){
							System.out.println("ya were hit left");
						}
					}
					// hit bottom
					if((int)(y) + height <= tileTopY && (int)(y) + height >= tileBottomY){
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							System.out.println("ya were hit bottom");
						}
					}
					// hit top
					if((int)(y) <= tileTopY && (int)(y) >= tileBottomY){
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							System.out.println("ya were hit top");
						}
					}
				// collidedTimes++;
				// System.out.println(i + "   werk?  " + collidedTimes);
				}
			}
		}
		System.out.println("left " + hitLeft + " right " + hitRight + " up " + hitAbove + " down " + hitBelow);
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
}

