package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {
 
    public Player(float x, float y) throws SlickException{
        super(x,y);
        sprite = new Image("testdata/wizardPerson.png");
    }
    public void moveLeft(int delta){
    	x = x - (.15f * delta);
    }
    
    public void moveRight(int delta){
    	x= x + (.15f * delta);
    }
    
    public void render(){
    	sprite.draw(x,y);
    }
}

