package game.character;
 
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
 
public abstract class Character {
    
	protected float x;
    protected float y;
    protected Image sprite;
    protected int height;
    protected int width;
    
    public Character(float x, float y) throws SlickException{
        this.x = x;
        this.y = y;
        //placeholder image
        sprite = new Image("testdata/grass.png");
        height = sprite.getHeight();
        width = sprite.getWidth();
    }
    
    public float getX(){
        return x;
    }
    
    public float getY(){
    	return y;
    }
    
    public void render(){
    	sprite.draw(x,y);
    }
}