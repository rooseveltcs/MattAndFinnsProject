package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
	protected Image sprite;
	// jumping stuff
	public int JUMPHEIGHT = 25;
	private int thisJumpHeight = 0;
	private int jumpStart;
	
	public Player(float x, float y) throws SlickException{
		super(x,y);
		sprite = new Image("testdata/wizardlady.png");
        	
    }	
		
	public void jump(int delta){
		jumpStart = (int) y;
		thisJumpHeight++;
		// System.out.println(y + "first is y,");
		// this needs to be more smooth, collision will handle fall
		if(y <= jumpStart + JUMPHEIGHT){
	    	 y = (float) y - (.35f - (thisJumpHeight / 30)) * delta;
	    	 System.out.println("delta " + delta + " thisjumpheight " + thisJumpHeight);
		}else{
	    
	    }
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

