package controller;
//test
import game.character.Player;
import org.newdawn.slick.Input;
import slickgame.SlickGame;

public class MouseAndKeyBoardControls {
	private Player controlledPlayer;
	
	public MouseAndKeyBoardControls(Player player){
		controlledPlayer = player;
		// map.Map.this.getTiles();
	}

	public void handleInput(Input i, int delta){
		if(i.isKeyDown(Input.KEY_LEFT)){
			controlledPlayer.moveRight(delta);
		}if(i.isKeyDown(Input.KEY_RIGHT)){
			controlledPlayer.moveLeft(delta);
		}if(i.isKeyDown(Input.KEY_UP)){
			controlledPlayer.hitBelow = false;
			controlledPlayer.setJumping(true);
		}else if(i.isKeyDown(Input.KEY_ESCAPE)){
			SlickGame.Game.enterState(0);
		}
	}
}
