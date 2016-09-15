package ar.catchthething.gdx.gameObjects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface GameObject {

    public abstract void update(float delta);

    public abstract void render(SpriteBatch batch);

}
