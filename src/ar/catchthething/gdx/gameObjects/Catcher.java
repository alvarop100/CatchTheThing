package ar.catchthething.gdx.gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ar.catchthething.gdx.game.GameContentManager;
import ar.catchthething.gdx.game.GameScreen;
import ar.catchthething.gdx.seed.Seed;

public class Catcher extends Sprite implements GameObject {

    private PlayerConfiguration configuration;
    private Sprite shadow;
    private Texture sprite;
    private float powerUp = 4f;
    private float cooldownPowerUp = 10f;
    private Boolean caught;
    private Animation animation;
    private Animation animationShadow;
    private float animationTime = 0;
    
    public Catcher(PlayerConfiguration configuration) {
    	
    	super(new TextureRegion(GameContentManager.catcher), 0,0, 200,200);
    	this.setPosition(0,15);
    	this.sprite = GameContentManager.catcher;
    	
    	shadow = new Sprite(new TextureRegion(GameContentManager.catcherShadow), 0,0, 200,200);
    	shadow.setPosition(0,15);
        
		TextureRegion[] sprites = new TextureRegion[8];
		for(int i = 0; i < sprites.length; i++) {
			sprites[i] = new TextureRegion(sprite, i * 32, 0, 32, 32);
		}
		animation = new Animation(1/9f,sprites);
		
		
        this.configuration = configuration;
    }

    @Override
    public void update(float delta) {
        updateMovement();
        updatePowerUpAndCooldown(delta);
        
    }

	private void updatePowerUpAndCooldown(float delta) {
		powerUp += delta;
        if(powerUp > 0) cooldownPowerUp -= delta;
	}

	private void updateMovement() {
		if(Gdx.input.isKeyPressed(this.configuration.getLeftKey())) {
            this.moveLeft();
        }
       
        if(Gdx.input.isKeyPressed(this.configuration.getRightKey())) {
            this.moveRight();
        }
        if(Gdx.input.isKeyPressed(this.configuration.getSpaceKey())){
        	this.spaceMovement();
        }
	}
	
	public void moveLeft() {
        if(powerUp < 3f) {
            this.translate(-10,0);
            this.shadow.translate(-10, 0);
        }else{
            this.translate(-5, 0);
            this.shadow.translate(-5, 0);
        }
    }

    public void moveRight() {
        if(powerUp < 3f) {
            this.translate(10,0);
            this.shadow.translate(10,0);
        }else{
            this.translate(5, 0);
            this.shadow.translate(5, 0);
        }
    }

    public void spaceMovement(){
        if(cooldownPowerUp < 0) {
            this.powerUp = 0;
            this.cooldownPowerUp = 10f;
        }
}

    @Override
    public void render(SpriteBatch sp) {
    	sp.begin();
    	shadow.draw(sp);
        super.draw(sp);
        /*animationTime += Gdx.graphics.getDeltaTime();
        TextureRegion currentFrame = animation.getKeyFrame(animationTime, true); 
        sp.draw(currentFrame, this.getX(), this.getY(), (float)85, (float)85, (float)170, (float)170, (float)1, (float)1, (float)angleDegrees + 270);*/
        sp.end();
    }
    
    public void onCaught(){
        caught = true;
    }
    public boolean isCaught(){
        return caught;
}
    
    public void checkCollisionWithSeedOnScreen(Seed semilla,GameScreen screen){
    	if(this.getBoundingRectangle().overlaps(semilla.getBoundingRectangle())){
            screen.addSeedToBeRemoved(semilla);
            this.onCaught();
            semilla.updateScoreOn(screen);
}
    }

   

}
