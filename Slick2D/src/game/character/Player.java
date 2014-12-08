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
	
	public void colliding(){	
		
	System.out.println(tileArray[2][14]);
	System.out.println(tileArray[19][5]);
	System.out.println(tileArray[56][7]);
	System.out.println(tileArray[45][2]);
/*	
		
	int collidedTimes = 0;
		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				int tileRightX = i*32 + 32;
				int tileLeftX = i*32;
				int tileTopY =  j*32 + 32;
				int tileBottomY = j*32;
				
				if((int)(x) + width <= tileRightX && (int)(x) + width >= tileLeftX || (int)(x) <= tileRightX && (int)(x) >= tileLeftX){
					if((int)(y) + height <= tileTopY && (int)(y) + height >= tileBottomY || (int)(y) <= tileTopY && (int)(y) >= tileBottomY){
						if(tileArray[i][j] instanceof SolidTile){
							collidedTimes++;
							System.out.println(i + "   werk?  " + collidedTimes);
						}
					}
				}
			}
		}
*/
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

