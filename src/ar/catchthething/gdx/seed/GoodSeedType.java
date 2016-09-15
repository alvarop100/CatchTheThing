package ar.catchthething.gdx.seed;

import com.badlogic.gdx.graphics.Texture;

import ar.catchthething.gdx.game.GameContentManager;
import ar.catchthething.gdx.game.GameScreen;

public class GoodSeedType extends SeedType {

	public Texture getTexture(){
		return GameContentManager.semilla;
	}
	
	 public void updateScoreOn(GameScreen screen){
	    	screen.updateGoodScore();
	    }
}
