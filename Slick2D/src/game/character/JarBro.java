package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class JarBro extends aiCharacter {
	
	public JarBro(float x, float y) throws SlickException {
		super(x, y);
		sprite = new Image("testdata/magicpot.png");
		
		//width = 27
		//height = 45
	}
}
