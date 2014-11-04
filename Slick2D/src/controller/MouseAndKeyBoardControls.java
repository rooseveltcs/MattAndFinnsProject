package controller;

import game.character.Player;
import org.newdawn.slick.Input;

public class MouseAndKeyBoardControls {
	private Player controlledPlayer;
	
	public MouseAndKeyBoardControls(Player player){
		controlledPlayer = player;
	}

	public void handleInput(Input i, int delta){
		if(i.isKeyDown(Input.KEY_LEFT)){
			controlledPlayer.moveRight(delta);
		}else if(i.isKeyDown(Input.KEY_RIGHT)){
			controlledPlayer.moveLeft(delta);
		}
	}
	
}
