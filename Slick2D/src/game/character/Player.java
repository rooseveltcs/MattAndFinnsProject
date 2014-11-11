package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
	protected Image sprite;
	public final int JUMPHEIGHT = 25;
	private double jumpGrav = 0;
	private int thisJumpHeight = 0;
	
	public Player(float x, float y) throws SlickException{
		super(x,y);
		sprite = new Image("testdata/wizardlady.png");
        	
    }	
		
	public void jump(int delta){
		//gravity amirite
		thisJumpHeight++;
		jumpGrav += thisJumpHeight/7;
		if(thisJumpHeight < JUMPHEIGHT){
	    	y = (float) (y - (.25f * delta - jumpGrav + 6));
	    }else{
	    	jumpGrav = 0;
	    	// System.out.println("test " + jumpGrav);
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

