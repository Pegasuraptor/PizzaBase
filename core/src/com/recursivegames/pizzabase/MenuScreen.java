package com.recursivegames.pizzabase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Package : com.recursivegames.pizzabase
 * Author : Matthew Hurst
 * Created : 15/09/2015 - 22:14
 */
public class MenuScreen implements Screen
{
	final PizzaBaseGame game;
	Viewport viewport;
	Stage stage;

	public MenuScreen(PizzaBaseGame g)
	{
		game = g;
		viewport = new FitViewport(game.screenWidth, game.screenHeight);

		stage = new Stage(viewport);
		Gdx.input.setInputProcessor(stage);

		Label.LabelStyle labelStyle = new Label.LabelStyle(game.font, Color.RED);
		Label label = new Label("PIZZA BASE", labelStyle);
		label.setFontScale(2.5f);
		Table table = new Table();
		//table.debug();
		table.setTransform(true);

		TextureRegionDrawable playNormal = new TextureRegionDrawable(new TextureRegion(game.manager.get("playbutton.png", Texture.class)));
		TextureRegionDrawable playDown = new TextureRegionDrawable(new TextureRegion(game.manager.get("playbutton_down.png", Texture.class)));

		TextureRegionDrawable exitNormal = new TextureRegionDrawable(new TextureRegion(game.manager.get("exitbutton.png", Texture.class)));
		TextureRegionDrawable exitDown = new TextureRegionDrawable(new TextureRegion(game.manager.get("exitbutton_down.png", Texture.class)));

		TextureRegionDrawable optionsNormal = new TextureRegionDrawable(new TextureRegion(game.manager.get("optionsbutton.png", Texture.class)));
		TextureRegionDrawable optionsDown = new TextureRegionDrawable(new TextureRegion(game.manager.get("optionsbutton_down.png", Texture.class)));

		TextureRegionDrawable creditsNormal = new TextureRegionDrawable(new TextureRegion(game.manager.get("creditsbutton.png", Texture.class)));
		TextureRegionDrawable creditsDown = new TextureRegionDrawable(new TextureRegion(game.manager.get("creditsbutton_down.png", Texture.class)));

		ImageButton playButton = new ImageButton(playNormal, playDown);
		playButton.setTransform(true);
		playButton.setOrigin(playButton.getPrefWidth() / 2, playButton.getPrefHeight() / 2);
		playButton.setScale(2.5f);

		ImageButton optionsButton = new ImageButton(optionsNormal, optionsDown);
		optionsButton.setTransform(true);
		optionsButton.setOrigin(optionsButton.getPrefWidth() / 2, optionsButton.getPrefHeight() / 2);
		optionsButton.setScale(2.5f);

		ImageButton exitButton = new ImageButton(exitNormal, exitDown);
		exitButton.setTransform(true);
		exitButton.setOrigin(exitButton.getPrefWidth() / 2, exitButton.getPrefHeight() / 2);
		exitButton.setScale(2.5f);

		ImageButton creditsButton = new ImageButton(creditsNormal, creditsDown);
		creditsButton.setTransform(true);
		creditsButton.setOrigin(creditsButton.getPrefWidth() / 2, creditsButton.getPrefHeight() / 2);
		creditsButton.setScale(2.5f);

		table.row();
		table.add(label).padTop(30f);
		table.row();
		table.add(playButton).padTop(500f).padBottom(100f);
		table.row();
		table.add(optionsButton).padTop(20f).padBottom(100f);;
		table.row();
		table.add(creditsButton).padTop(20f).padBottom(100f);;
		table.row();
		table.add(exitButton).padTop(20f);
		table.setFillParent(true);
		table.pack();

		stage.addActor(table);
	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 60.0f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height)
	{
		viewport.update(width, height);
	}

	@Override
	public void pause()
	{

	}

	@Override
	public void resume()
	{

	}

	@Override
	public void hide()
	{

	}

	@Override
	public void dispose()
	{

	}
}
