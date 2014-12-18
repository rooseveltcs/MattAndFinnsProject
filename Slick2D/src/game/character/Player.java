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
	// The collision method and booleans should go in character when finished
	// Where the player's sprite collided
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
		if(hitAbove){
			System.out.println("hitabove");
		}
		double jumpSpeed = 2;
		thisJumpHeight++;		
		// fix this  when actual collision works
		if(y <= 430){
			y = (float) y -  (float)(jumpSpeed * (.35 - thisJumpHeight / 60) * delta);
		}else{
			thisJumpHeight = 0;
			setJumping(false);
			y -= 10.667;
		/*
		double jumpSpeed = 2;
		thisJumpHeight++;		
		// fix this  when actual collision works
		if(hitBelow || thisJumpHeight == 0){
			y = (float) y -  (float)(jumpSpeed * (.35 - thisJumpHeight / 60) * delta);
		}else{
			thisJumpHeight = 0;
			setJumping(false);
		*/
		}
	}

	public void colliding(){	

		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				int tileRightX = i*32 + 32;
				int tileLeftX = i*32;
				int tileBottomY =  j*32 + 32;
				int tileTopY = j*32;
				
				if(tileArray[i][j] instanceof SolidTile){
					// hit right collision
					if(((int)(y) >= tileTopY && (int)(y) <= tileBottomY)){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}
					}else if((((int)(y) + height) >= tileTopY && ((int)(y) + height) <= tileBottomY)){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}
					}else if(((int)(y) <= tileTopY && ((int)(y) + height) >= tileBottomY)){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
					}
						
					// hit top collision
					}else if((int)(y) <= tileBottomY && (int)(y) >= tileTopY){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitAbove = true;
							System.out.println("gat ya right above");
						}
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitAbove = true;
							System.out.println("gat ya left above");
						}
					// System.out.println("thishappened atleast");
					}
					
										
					/*	
					if(((int)(y) <= tileTopY && (int)(y) >= tileBottomY) || ((int)(y) + height <= tileTopY && (int)(y) + height >= tileBottomY ||((int)(y) + height <= tileTopY && (int)(y) + height >= tileBottomY))){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitLeft = true;
						}
					}
			
					if((int)(y) >= tileTopY && (int)(y) <= tileBottomY){
					//hit right
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}else{
						 	hitRight = false;
						}
					//hit left
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitLeft = true;
						}else{
							hitLeft = false;
						}
					hitAbove = true;
					
					}if((int)(y) <= tileTopY && ((int)(y) + height) >= tileBottomY){
					//hit right	
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}else{
						 	hitRight = false;
						}
					//hit left
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitLeft = true;
						}else{
							hitLeft = false;
						}
					}
					// hit below
					if(((int)(y) + height) <= tileBottomY && ((int)(y) + height) >= tileTopY){
					//hit right	
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}else{
							hitRight = false;
						}
						//hit left
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitLeft = true;
						}else{
							hitLeft = false;
						}	
					hitBelow = true;
					}else{
						hitBelow = false;
					}
					*/					
				}
			}
		}
	//	System.out.println(hitLeft + "  " + hitRight + "  " + hitAbove + "  " + hitBelow);
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
    	hitRight = false;
    }	
    //move right	
    public void moveLeft(int delta){
    	if(!hitRight){
    		x = x + (.25f * delta);
    	}
    	hitLeft = false;
    }   
}

