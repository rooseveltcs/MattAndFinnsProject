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
		double jumpSpeed = 2;
		double fallSpeed = thisJumpHeight / 60;
		
		thisJumpHeight++;		

		if(y <= 400){
			y = (float) y -  (float)(jumpSpeed * (.35 - fallSpeed) * delta);
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
		// problem with top tile, prob because the character can get stuck in two tiles at once.
		
		// height 46
		// width 29
		
		//  3 X 4 grid surrounding the character
		
		// FAR RIGHT COLUMN
		//  3 x 4
		if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
			hitRight = true;
		}
		//  3 x 3
		if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)) + 32)/32)] instanceof SolidTile){
			hitRight = true;
		}
		//  3 x 2
		if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)))/32)] instanceof SolidTile){
			hitRight = true;
		}
		//  3 x 1
		if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)) - 32)/32)] instanceof SolidTile){
			hitRight = true;
		}
		
		// MIDDLE COLUMN
		//  2 X 1
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) - 32)/32)] instanceof SolidTile){
			// this hits on the top left most tile, should only hit on top middle
			hitAbove = true;
		}
		//  2 X 4
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
			hitBelow = true;
		}
		
		// FAR LEFT COLUMN
		//  1 x 1
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) - 32)/32)] instanceof SolidTile){
			hitLeft = true;
		}
		//  1 x 2
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)))/32)] instanceof SolidTile){
			hitLeft = true;
		}
		//  1 x 3
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) + 32)/32)] instanceof SolidTile){
			hitLeft = true;
		}
		//  1 x 4
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
			hitLeft = true;
		}
		
		/*
		for(int i = 0; i <= row - 1; i++){
			for(int j = 0; j <= col - 1; j++){
				int tileRightX = i*32 + 32;
				int tileLeftX = i*32;
				int tileBottomY =  j*32 + 32;
				int tileTopY = j*32;
				
				if(tileArray[i][j] instanceof SolidTile){
					// top RIGHT corner inside hit box?
					if(((int)(y) >= tileTopY && (int)(y) <= tileBottomY)){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}
					}
					// bottom RIGHT corner inside hit box?
					if((((int)(y) + height) >= tileTopY && ((int)(y) + height) <= tileBottomY)){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}
					}
					// top LEFT corner inside hit box?
					if(((int)(y) >= tileTopY && (int)(y) <= tileBottomY)){
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitLeft = true;
						}
					}
					// bottom LEFT corner inside hit box?
					if((((int)(y) + height) >= tileTopY && ((int)(y) + height) <= tileBottomY)){
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitLeft = true;
						}
					}
					// hit box is inside the player
					if(((int)(y) <= tileTopY && ((int)(y) + height) >= tileBottomY)){
						if(((int)(x) + width) <= tileRightX && ((int)(x) + width) >= tileLeftX){
							hitRight = true;
						}
						if((int)(x) <= tileRightX && (int)(x) >= tileLeftX){
							hitLeft = true;
						}
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
				}
			}
			*/	
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

