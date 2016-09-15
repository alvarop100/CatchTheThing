package ar.catchthething.gdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import ar.catchthething.gdx.gameObjects.Catcher;
import ar.catchthething.gdx.seed.Seed;

public class GameScreen extends ScreenAdapter {

    private CatchTheThing game;
    private OrthographicCamera camera;
    private GameScreenContent content;
    private int score;
    private String scoreLabel;
    BitmapFont font;
    
    

    public GameScreen(CatchTheThing game) {
    	Texture.setEnforcePotImages(false);
        this.game = game;
        this.content = new GameScreenContent(this);
        this.initializeCamera();
        this.initializeScore();
    }
    public void initializeScore(){
    	score = 0;
    	scoreLabel = "Score: 0";
    	font = new BitmapFont();
    }
    @Override
    public void render(float delta) {
        
        this.renderBackground();
        this.renderContent();
        this.update(delta);
 
    }
    private void renderBackground(){
    	this.getSpriteBatch().begin();
        GameContentManager.backgroundSprite.draw(this.getSpriteBatch());
        this.getSpriteBatch().end();
    }
    private void renderContent(){
    	content.render(this.getSpriteBatch());
    	renderScore();
    }
    private void renderScore(){
    	this.getSpriteBatch().begin(); 
    	font.setColor(1.0f, 1.0f, 1.0f, 1.0f);
    	font.draw(this.getSpriteBatch(), scoreLabel, 25, 100); 
    	this.getSpriteBatch().end();
    }
    private void update(float delta) {
        this.camera.update();
        this.content.update(delta);
    }

   
    
    private void initializeCamera() {
        this.camera = new OrthographicCamera(CatchTheThing.SCREEN_WIDTH, CatchTheThing.SCREEN_HEIGHT);
    }
    
    private SpriteBatch getSpriteBatch(){
    	return game.getSpriteBatch();
    }
    
    public Catcher getCatcher(){
    	return content.getCatcher();
    }
    public void removeSeed(Seed semilla){
    	content.removeSeed(semilla);
    }
    public void addSeed(Seed semilla){
    	content.addSeed(semilla);
    }
    public void addSeedToBeRemoved(Seed semilla){
    	content.addSeedToBeRemoved(semilla);
    }
    public void removeSeedsToBeRemoved(){
    	content.removeSeedsToBeRemoved();
    }
    public void updateGoodScore(){
    	score++;
        scoreLabel = "Score: " + score;
        //GameContentManager.caughtGoodSound.play();
    }
    public void updateBadScore(){
    	if(score>0)score--;
    	
        scoreLabel = "Score: " + score;
        //GameContentManager.caughtBadSound.play();
    }
}
