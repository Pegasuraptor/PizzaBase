package com.recursivegames.pizzabase.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.recursivegames.pizzabase.PizzaBaseGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 480;
		config.height = 720;
		new LwjglApplication(new PizzaBaseGame(), config);
	}
}
