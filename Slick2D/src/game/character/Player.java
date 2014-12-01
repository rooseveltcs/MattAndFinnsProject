package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import tiles.Tile;
import map.*;

public class Player extends Character {
	protected Image sprite;
	private double thisJumpHeight = 0;
	private boolean jumping;
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
		// tileArray = map.Map.map.getTiles();
		// row = tileArray.length;
		// col = tileArray[0].length;
	}	
	
	public void jump(int delta){
		double jumpSpeed = 2;
		thisJumpHeight++;		
		// fix this  when actual collision works
		if(y <= 420.0){
			y = (float) y -  (float)(jumpSpeed * (.35 - thisJumpHeight / 60) * delta);
		}else{
			thisJumpHeight = 0;
			setJumping(false);
			// this is the exact offset between where the sprite lands, and the boundary on the if statement
			y -= 10.667;
		}
	}
	
	public void colliding(){
	//	for(int i = 0; i <= row; i++){
	//		for(int j = 0; j <= col; j++){
	//			if((int)(x) + width <= tileArray[i][j].getX() + 32 && (int)(x) + width >= tileArray[i][j].getX() || (int)(x) <= tileArray[i][j].getX() + 32 && (int)(x) >= tileArray[i][j].getX()){
	//			 	System.out.println("did werk!!! :D");
	//			}
	//			if((int)(y/32) == tileArray[i][j].getY()){
	//			
	//			}
	//		}
	//	}
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

