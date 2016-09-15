package ar.catchthething.gdx.gameObjects;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ar.catchthething.gdx.game.GameScreen;
import ar.catchthething.gdx.seed.Seed;
import ar.catchthething.gdx.seed.SeedType;

public class Spawner {

	
	 	private float cooldown;
	    private float timer;
	    private GameScreen screen;
	    
	    public Spawner(GameScreen screen){
	    	this.screen = screen;
	        timer = 0.0f;
	        cooldown = this.generateCooldown() * 2;
	    }
	    
	    public float generateCooldown() {
	        float newNumber = new Random().nextFloat();
	        return ( newNumber* 0.5f) + 0.2f;
	}
	    
	    
	    public void update(float  delta) {
	        if(timer >= cooldown) {
	            this.spawnSeed();
	            timer = 0;
	            cooldown = this.generateCooldown() * 2;
	        } else {
	            timer += delta;
	        }
	    }

	    
	    public void render(SpriteBatch spriteBatch){}

	    private void spawnSeed() {
	        this.screen.addSeed(new Seed(this.screen,SeedType.randomType()));
	}

}
