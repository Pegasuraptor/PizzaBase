package com.recursivegames.pizzabase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

/**
 * Package : com.recursivegames.pizzabase
 * Author : Matthew Hurst
 * Created : 24/09/2015 - 21:51
 */
public class GameScreen implements Screen
{
	private PizzaBaseGame game;
	private Sprite testSprite;

	private Sprite[] sprites;
	private Order newOrder;
	private int numberClicked = 0;
	private int[] guess;

	public GameScreen(PizzaBaseGame game)
	{
		this.game = game;
		testSprite = new Sprite(game.manager.get("badlogic.jpg", Texture.class));
		testSprite.setPosition(0, 0);

		sprites = new Sprite[5];
		for (int i = 0; i < 5; ++i)
		{
			sprites[i] = new Sprite(game.manager.get("badlogic.jpg", Texture.class));
			sprites[i].setPosition(0, i * (sprites[i].getRegionHeight() + 30) + 50);
		}

		GetNewOrder();
	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		Update();
		Draw();
	}

	private void Update()
	{
		if (Gdx.input.justTouched())
		{
			Vector3 temp = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			game.camera.unproject(temp);

			for(int i = 0; i < 5; ++i)
			{
				if (sprites[i].getBoundingRectangle().contains(temp.x, temp.y))
				{
					Gdx.app.log("Click", "Clicked :" + i);
					guess[numberClicked] = i;
					numberClicked++;
				}
			}
		}

		if (newOrder.solved)
		{
			GetNewOrder();
		}

		if (numberClicked >= 3)
		{
			if (newOrder.CheckOrder(guess))
			{
				Gdx.app.log("Guess", "CORRECT");
			}
			else
			{
				Gdx.app.log("Guess", "INCORRECT");
			}

			newOrder.solved = true;
		}


	}

	private void GetNewOrder()
	{
		newOrder = new Order(3);
		numberClicked = 0;
		guess = new int[3];
	}

	private void Draw()
	{
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		game.batch.begin();
		game.batch.setProjectionMatrix(game.camera.combined);
		for (int i = 0; i < 5; ++i)
		{
			sprites[i].draw(game.batch);
		}
		game.batch.end();
	}

	@Override
	public void resize(int width, int height)
	{
		game.viewport.update(width, height);
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
