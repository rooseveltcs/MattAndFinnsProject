package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class JarBro extends aiCharacter {
	
	//Not a lot to see here - basic ai is in aiCharacter, and multiple characters haven't
	//been implemented yet, so there's no need to change something here. may add unique behavior in the future.
	public JarBro(float x, float y) throws SlickException {
		super(x, y);
		sprite = new Image("testdata/magicpot.png");
		
		//width = 27
		//height = 45
	}
}
