package Physics;

import java.util.ArrayList;
import tiles.Tile;

public abstract class BoundingShape {
	
	public boolean checkCollision(BoundingShape bv){
		if(bv instanceof AABoundingRectangle){
			return checkCollision((AABoundingRectangle) bv);
		}
		return false;
	}	
	
	public abstract boolean checkCollision(AABoundingRectangle box);
	public abstract void updatePosition(float newX, float newY);
	public abstract void movePosition(float x, float y);
	public abstract ArrayList<Tile> getTilesOccupying(Tile[][] tiles);
	public abstract ArrayList<Tile> getGroundTiles(Tile[][] tiles);
}
