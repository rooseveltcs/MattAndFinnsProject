package game.character;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class JarBro extends aiCharacter {

	public JarBro(float x, float y) throws SlickException {
		super(x, y);
		sprite = new Image("testdata/magicpot.png");

	}
}
