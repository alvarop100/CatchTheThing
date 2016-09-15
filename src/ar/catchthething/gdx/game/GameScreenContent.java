package ar.catchthething.gdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ar.catchthething.gdx.gameObjects.Catcher;
import ar.catchthething.gdx.gameObjects.PlayerConfiguration;
import ar.catchthething.gdx.gameObjects.Spawner;
import ar.catchthething.gdx.gameObjects.Sun;
import ar.catchthething.gdx.seed.Seed;


public class GameScreenContent {

    private Catcher catcher;
    private PlayerConfiguration playerConfiguration;
    private Spawner spawner;
    private List<Seed> semillas;
    private List<Seed> seedsToBeRemoved;
    
    private Sun sun;
    

    public GameScreenContent(GameScreen screen) {
    	sun = new Sun();
    	semillas=new ArrayList<Seed>();
    	seedsToBeRemoved=new ArrayList<Seed>();
    	spawner= new Spawner(screen);
        this.initializePlayersConfiguration();
        this.initializeCatcher();
    }

    public void update(float delta) {
        catcher.update(delta);
        sun.update(delta);
        spawner.update(delta);
        this.seedsUpdate(delta);
        this.removeSeedsToBeRemoved();
    }

    public void render(SpriteBatch sp) {
        catcher.render(sp);
        sun.render(sp);
        spawner.render(sp);
        this.seedsRender(sp);
    }
    private void seedsRender(SpriteBatch sp){
    	for(Seed s: semillas){
    		s.render(sp);
    	}
    }
    private void seedsUpdate(float delta){
    	for(Seed s: semillas){
    		s.update(delta);
    	}
    }

    private void initializeCatcher() {
        catcher = new Catcher(this.playerConfiguration);
       
    }

    private void initializePlayersConfiguration() {
        this.playerConfiguration = new PlayerConfiguration();
        
    }
    
    public Catcher getCatcher(){
    	return catcher;
    }
    public void removeSeed(Seed semilla){
    	semillas.remove(semilla);
    }
    public void addSeed(Seed semilla){
    	semillas.add(semilla);
    }
    public void addSeedToBeRemoved(Seed semilla){
    	seedsToBeRemoved.add(semilla);
    }
    public void removeSeedsToBeRemoved(){
    	for(Seed s: seedsToBeRemoved){
    		semillas.remove(s);
    	}
    	seedsToBeRemoved=new ArrayList<Seed>();
    }


}
