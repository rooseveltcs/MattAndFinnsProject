package controller;

import game.character.Player;
import org.newdawn.slick.Input;

public class MouseAndKeyBoardControls {
private Player player;
	public MouseAndKeyBoardControls(Player player){
		player = player;
	}

	public void handleInput(Input i, int delta){
		if(i.isKeyDown(Input.KEY_LEFT)){
			player.moveRight(delta);
		}
	}
	
}
