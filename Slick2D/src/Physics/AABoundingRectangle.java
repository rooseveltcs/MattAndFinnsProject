package Physics;

import java.util.ArrayList;

import tiles.Tile;

public class AABoundingRectangle extends BoundingShape{
	public float x;
	public float y;
	public float width;
	public float height;
	
	public AABoundingRectangle(float x, float y, float width, float height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void updatePosition(float newX, float newY){
		this.x = newX;
		this.y = newY;
	}
	
	public void movePosition(float x, float y){
		this.x += x;
		this.y += y;
	}

	public boolean checkCollision(AABoundingRectangle rekt) {
		return !(rekt.x > this.x + width || rekt.x + rekt.width < this.x || rekt.y );
	}

	public ArrayList<Tile> getTilesOccupying(Tile[][] tiles) {
		return null;
	}

	public ArrayList<Tile> getGroundTiles(Tile[][] tiles) {
		return null;
	}
}

