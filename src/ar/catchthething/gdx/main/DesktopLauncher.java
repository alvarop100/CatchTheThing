package ar.catchthething.gdx.main;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ar.catchthething.gdx.game.CatchTheThing;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Catch The Thing";
		config.height = CatchTheThing.SCREEN_HEIGHT;
		config.width = CatchTheThing.SCREEN_WIDTH;
		new LwjglApplication(new CatchTheThing(),config);
	}
}
