package controller;

import game.character.Player;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import slickgame.SlickGame;

public class MouseAndKeyBoardControls {
	private Player controlledPlayer;
	
	public MouseAndKeyBoardControls(Player player){
		controlledPlayer = player;
		// map.Map.this.getTiles();
	}

	public void handleInput(Input i, int delta) throws SlickException{
		if(i.isKeyDown(Input.KEY_LEFT)){
			controlledPlayer.moveRight(delta);
		}if(i.isKeyDown(Input.KEY_RIGHT)){
			controlledPlayer.moveLeft(delta);
		}if(i.isKeyDown(Input.KEY_UP)){
			controlledPlayer.hitBelow = false;
			controlledPlayer.setJumping(true);
		}if(i.isKeyPressed(Input.KEY_SPACE)){
			controlledPlayer.rangedAttack((controlledPlayer.getY() - Mouse.getY()) / (controlledPlayer.getX() - Mouse.getX()));	
		}else if(i.isKeyDown(Input.KEY_ESCAPE)){
			SlickGame.Game.enterState(0);
		}
	}
}
