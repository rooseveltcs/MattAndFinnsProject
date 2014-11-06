package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
	protected Image sprite;
	
	public Player(float x, float y) throws SlickException{
        super(x,y);
       sprite = new Image("testdata/wizardlady.png");
        
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

