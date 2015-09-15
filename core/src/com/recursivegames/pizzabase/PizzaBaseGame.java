package com.recursivegames.pizzabase;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class PizzaBaseGame extends Game
{
	public int screenWidth = 1080;
	public int screenHeight = 1920;
	public SpriteBatch batch;
	public OrthographicCamera camera;
	public Viewport viewport;
	public AssetManager manager;
	public BitmapFont font;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.position.set(screenWidth / 2, screenHeight / 2, 0);
		viewport = new FitViewport(screenWidth, screenHeight, camera);
		manager = new AssetManager();

		LoadAssets();

		font = manager.get("KenPixelNova_96.fnt", BitmapFont.class);

		setScreen(new MenuScreen(this));
	}

	private void LoadAssets()
	{
		//todo move this into a loading screen class to do async
		manager.load("KenPixelNova_96.fnt", BitmapFont.class);
		manager.load("playbutton.png", Texture.class);
		manager.load("playbutton_down.png", Texture.class);

		manager.load("optionsbutton.png", Texture.class);
		manager.load("optionsbutton_down.png", Texture.class);

		manager.load("creditsbutton.png", Texture.class);
		manager.load("creditsbutton_down.png", Texture.class);

		manager.load("exitbutton.png", Texture.class);
		manager.load("exitbutton_down.png", Texture.class);
		manager.finishLoading();
	}

}
