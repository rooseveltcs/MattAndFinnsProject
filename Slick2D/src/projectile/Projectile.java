package projectile;

import org.newdawn.slick.Image;

public class Projectile {
protected float x;
protected float y;
protected double slope;

	public Projectile(float newX, float newY, double newSlope){
		this.x = newX;
		this.y = newY;
		this.slope = newSlope;
	}
}
