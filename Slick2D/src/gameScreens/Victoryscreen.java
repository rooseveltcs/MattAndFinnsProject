package gameScreens;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Victoryscreen extends BasicGameState implements KeyListener{
	private Image ball1;
	private Image ball2;
	private Image ball3;
	private Image ball4;
	private Image ball5;
	private Image ball6;
	private Image ball7;
	private Image ball8;
	private Image ball9;
	private Image ball10;
	private Image ball11;
	private Image ball12;
	private Image ball13;
	private Image ball14;
	private Animation animation;
	private Image[] animationFrames;
	private int delay = 95;
	
	@Override
	public void init(GameContainer game, StateBasedGame arg1) throws SlickException {
		animationFrames = new Image[14];
		ball1 = new Image("testdata/anims/ball1.png");
		ball2 = new Image("testdata/anims/ball2.png");
		ball3 = new Image("testdata/anims/ball3.png");
		ball4 = new Image("testdata/anims/ball4.png");
		ball5 = new Image("testdata/anims/ball5.png");
		ball6 = new Image("testdata/anims/ball6.png");
		ball7 = new Image("testdata/anims/ball7.png");
		ball8 = new Image("testdata/anims/ball8.png");
		ball9 = new Image("testdata/anims/ball9.png");
		ball10 = new Image("testdata/anims/ball10.png");
		ball11 = new Image("testdata/anims/ball11.png");
		ball12 = new Image("testdata/anims/ball12.png");
		ball13 = new Image("testdata/anims/ball13.png");
		ball14 = new Image("testdata/anims/ball14.png");
		animationFrames[0] = ball1;
		animationFrames[1] = ball2;
		animationFrames[2] = ball3;
		animationFrames[3] = ball4;
		animationFrames[4] = ball5;
		animationFrames[5] = ball6;
		animationFrames[6] = ball7;
		animationFrames[7] = ball8;
		animationFrames[8] = ball9;
		animationFrames[9] = ball10;
		animationFrames[10] = ball11;
		animationFrames[11] = ball12;
		animationFrames[12] = ball13;
		animationFrames[13] = ball14;
		animation = new Animation();		
		animation.addFrame(animationFrames[0], delay);
		animation.addFrame(animationFrames[1], delay);
		animation.addFrame(animationFrames[2], delay);
		animation.addFrame(animationFrames[3], delay);
		animation.addFrame(animationFrames[4], delay);
		animation.addFrame(animationFrames[5], delay);
		animation.addFrame(animationFrames[6], delay);
		animation.addFrame(animationFrames[7], delay);
		animation.addFrame(animationFrames[8], delay);
		animation.addFrame(animationFrames[9], delay);
		animation.addFrame(animationFrames[10], delay);
		animation.addFrame(animationFrames[11], delay);
		animation.addFrame(animationFrames[12], delay);
		animation.addFrame(animationFrames[13], delay);
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g) throws SlickException {
		// frame.draw();
		// g.drawString(theEnd, 450, 250);
		animation.draw(0, 0);
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		
	}

	@Override
	public int getID() {
		return 2;
	}

}
