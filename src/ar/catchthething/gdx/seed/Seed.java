package ar.catchthething.gdx.seed;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ar.catchthething.gdx.game.GameScreen;

public class Seed extends Sprite{

	 Vector2 initialAcceleration = new Vector2(0, -10); 
	 Vector2 initialVelocity = new Vector2(new Random().nextFloat() * 10, 0);
	 GameScreen screen;
	 SeedType type;

	    public Seed(GameScreen screen,SeedType type){
	        super(type.getTexture());
	        this.setPosition(0,550);
	        this.screen = screen;
	        this.type=type;
	}
	    
	    public void update(float delta) {
	        this.translate(initialVelocity.x + initialAcceleration.x * delta , initialVelocity.y + initialAcceleration.y * delta);
	        this.checkCollisionWithCatcher();
	        this.updateVelocity(delta);
	}
	    
	    private void checkCollisionWithCatcher(){
	        this.screen.getCatcher().checkCollisionWithSeedOnScreen(this,screen);
	}
	    
	    private void updateVelocity(float delta){
	        initialVelocity = new Vector2(initialVelocity.x + initialAcceleration.x * delta , initialVelocity.y + initialAcceleration.y * delta);
	}
	    
	    public void render(SpriteBatch spriteBatch) {
	        float angle = (new Vector2(this.initialVelocity.x, this.initialVelocity.y).angle()) + 90;
	        spriteBatch.begin();
	        spriteBatch.draw(new TextureRegion(this.getTexture()), this.getX(), this.getY(), this.getOriginX(), this.getOriginY(), this.getWidth(), this.getHeight(),this.getScaleX(), this.getScaleY(), angle);
	        spriteBatch.end();
	}
	    
	    public void updateScoreOn(GameScreen screen){
	    	type.updateScoreOn(screen);
	    }
}
