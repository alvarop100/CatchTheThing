package ar.catchthething.gdx.gameObjects;

import com.badlogic.gdx.Input;

public class PlayerConfiguration {

    
    private int leftKey;
    private int rightKey;
    private int spaceKey;

   public PlayerConfiguration(){
	   leftKey= Input.Keys.LEFT;
	   rightKey=Input.Keys.RIGHT;
	   spaceKey=Input.Keys.SPACE;
   }

    public int getLeftKey() {
        return this.leftKey;
    }

    public int getRightKey() {
        return this.rightKey;
    }

    public int getSpaceKey(){
    	return this.spaceKey;
    }
}
