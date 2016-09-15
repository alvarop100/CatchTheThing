package ar.catchthething.gdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CatchTheThing extends Game {

	public static final int SCREEN_WIDTH = 800;
	public static final int SCREEN_HEIGHT = 600;
	public SpriteBatch sp;

	@Override
	public void create () {
		sp = new SpriteBatch();
		setScreen(new GameScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	public SpriteBatch getSpriteBatch(){
	    return this.sp;
}
}
