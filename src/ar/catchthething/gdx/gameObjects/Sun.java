package ar.catchthething.gdx.gameObjects;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ar.catchthething.gdx.game.GameContentManager;

public class Sun extends Sprite{

	
	 	private float currentRotation;
	    private float rotationSpeed;

	    public Sun(){
	        super(GameContentManager.sun);
	        this.translate(-150,-150);
	        this.currentRotation = 0.0f;
	        this.rotationSpeed = (float)(Math.PI) / 1000f;
	    }

	    public void update(float deltaTime){
	        currentRotation += rotationSpeed * deltaTime;
	    }

	    public void render(SpriteBatch spriteBatch){
	        this.rotate(currentRotation);
	        spriteBatch.begin();
	        this.draw(spriteBatch);
	        spriteBatch.end();
	}
}
