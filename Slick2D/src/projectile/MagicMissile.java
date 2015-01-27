package projectile;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class MagicMissile extends Projectile {
private Image missile;	
private int speed = 1;

	public MagicMissile(float newX, float newY, double slope) throws SlickException {
		super(newX, newY, slope);
		missile = new Image("testdata/MagicMissile.png");
	}
	
	public void setSpeed(int newSpeed){
		speed = newSpeed;
	}
	
	public void render(){
		missile.draw(x, y);
	}
	
	public void update() {
		y = (float) (y + slope);
		x++;
	}
	
}
