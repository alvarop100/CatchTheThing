package ar.catchthething.gdx.seed;

import java.util.Random;

import com.badlogic.gdx.graphics.Texture;

import ar.catchthething.gdx.game.GameScreen;

public abstract class SeedType {

	public static SeedType randomType(){
		int random =new Random().nextInt(4) + 1;
		if(random==4){
			return new BadSeedType();
		}
		else{
			return new GoodSeedType();
		}
	}
	public abstract Texture getTexture();
	public abstract void updateScoreOn(GameScreen screen);
}
