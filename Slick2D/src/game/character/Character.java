package game.character;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import slickgame.SlickGame;
import tiles.SolidTile;
import tiles.Tile;
 
public abstract class Character {
	public boolean hitLeft;
	public boolean hitRight;
	public boolean hitAbove;
	public boolean hitBelow;
	protected float x;
    protected float y;
    protected Image sprite;
    protected int height;
    protected int width;
	protected Tile[][] tileArray;
	protected boolean jumping = false;
    
    public Character(float x, float y) throws SlickException{
        this.x = x;
        this.y = y;
        // placeholder image
        sprite = new Image("testdata/grass.png");
        height = sprite.getHeight();
        width = sprite.getWidth();
		tileArray = SlickGame.Game.level1.getTiles();
    }
    
    public float getX(){
        return x;
    }
    
    public float getY(){
    	return y;
    }
    
    public void render(float offset_x, float offset_y){
    	sprite.draw(x - offset_x, y - offset_y);
    }
    
    public int findBlock(float axis,int modifier, int shift){
    	return (int) (((axis - (axis % 32)  + (32 * modifier)) / 32)) + shift;
    }
    
    public void colliding() {	
		// height 46
		// width 29
		
		//  3 X 4 grid surrounding the character
		
		// FAR RIGHT COLUMN
		//  3 x 4
		/*
		if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
			hitRight = true;
		}
		*/
		//  3 x 3
		//  3 x 2
		if(tileArray[findBlock(x, 1, 0)][findBlock(y,1,0)] instanceof SolidTile){
			hitRight = true;
		}else if(tileArray[findBlock(x, 1, 0)][findBlock(y, 0, 0)] instanceof SolidTile){
			hitRight = true;
		}else{
			hitRight = false;
		}
		//  3 x 1
		/*
		if(tileArray[(int)(((x - (x%32)) + 32)/32)][(int)(((y - (y%32)) - 32)/32)] instanceof SolidTile){
			hitRight = true;
		}
		*/
		
		// MIDDLE COLUMN
		//  2 X 1
		// This is bugged similairly to how the bottom collision would mod(%) in the wrong direction.
		if(tileArray[findBlock(x, 0, 0)][findBlock(y,-1,1)] instanceof SolidTile){
			hitAbove = true;
		}else{
			hitAbove = false;
		}
		//  2 X 4
		if(hitLeft){
			if(tileArray[findBlock(x, 0, 1)][findBlock(y, 2, 0)] instanceof SolidTile){
				hitBelow = true;
				if(!jumping){	
					y = y - (y % 32) + 17;
				}
			}
		}else if(hitRight){
			if(tileArray[findBlock(x, 0, 0)][findBlock(y, 2, 0)] instanceof SolidTile){
				hitBelow = true;
				if(!jumping){	
					y = y - (y % 32) + 17;
				}
			}
		}else if(tileArray[findBlock(x, 0, 0)][findBlock(y, 2, 0)] instanceof SolidTile || tileArray[findBlock(x, 0, 1)][findBlock(y, 2, 0)] instanceof SolidTile){
			hitBelow = true;
			if(!jumping){	
				y = y - (y % 32) + 17;
			}
		}else{
			hitBelow = false;
		}
			
	
		// FAR LEFT COLUMN
		//  1 x 1
		/*
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) - 32)/32)] instanceof SolidTile){
			hitLeft = true;
		}
		*/
		//  1 x 2
		//  1 x 3
		if(tileArray[findBlock(x, 0, 0)][findBlock(y, 0, 0)] instanceof SolidTile){
			hitLeft = true;
		}else if(tileArray[findBlock(x, 0, 0)][findBlock(y, 1, 0)] instanceof SolidTile){
			hitLeft = true;
		}else{
			hitLeft = false;
		}
		//  1 x 4
		/*
		if(tileArray[(int)(((x - (x%32)))/32)][(int)(((y - (y%32)) + (32 * 2))/32)] instanceof SolidTile){
			hitLeft = true;
		}
		*/
	}
}