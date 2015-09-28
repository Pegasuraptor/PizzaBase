package com.recursivegames.pizzabase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

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
	private Customer[] customers;
	private int numberClicked = 0;
	private int[] guess;
	private float nextCustomerTimer;

	public GameScreen(PizzaBaseGame game)
	{
		this.game = game;
		testSprite = new Sprite(game.manager.get("badlogic.jpg", Texture.class));
		testSprite.setPosition(0, 0);

		sprites = new Sprite[5];
		for (int i = 0; i < 5; ++i)
		{
			sprites[i] = new Sprite(game.manager.get("badlogic.jpg", Texture.class));
			sprites[i].setPosition(game.viewport.getWorldWidth() - sprites[i].getWidth(), (game.viewport.getWorldHeight() * 0.2f * i) + (((game.viewport.getWorldHeight() * 0.2f) - sprites[i].getHeight()) * 0.5f));
		}

		nextCustomerTimer = 5.0f;

		customers = new Customer[4];

		for(int i = 0; i < customers.length; i++)
		{
			customers[i] = new Customer(game, i);
		}

		startNewOrder();
	}

	@Override
	public void show()
	{

	}

	@Override
	public void render(float delta)
	{
		Update(delta);
		Draw();
	}

	private void Update(float delta)
	{
		nextCustomerTimer -= delta;

		if(nextCustomerTimer <= 0.0f)
		{
			spawnNewCustomer();
			nextCustomerTimer = 5.0f;
		}

		if (Gdx.input.justTouched())
		{
			Vector3 temp = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
			game.camera.unproject(temp);

			for(int i = 0; i < 5; ++i)
			{
				if (sprites[i].getBoundingRectangle().contains(temp.x, temp.y) && numberClicked < 3)
				{
					Gdx.app.log("Click", "Clicked :" + i);
					guess[numberClicked] = i;
					numberClicked++;
				}
			}

			if (numberClicked >= 3)
			{
				for(int i = 0; i < customers.length; i++)
				{
					if (customers[i].getSprite().getBoundingRectangle().contains(temp.x, temp.y) && customers[i].isServed() == false)
					{
						customers[i].checkOrder(guess);
						startNewOrder();
					}
				}
			}
		}
	}

	private void startNewOrder()
	{
		numberClicked = 0;
		guess = new int[3];
	}

	private void spawnNewCustomer()
	{
		Array freeSlots = new Array(customers.length);

		for(int i = 0; i < customers.length; i++)
		{
			if(customers[i].isServed())
			{
				freeSlots.add(i);
			}
		}

		freeSlots.shrink();

		if(freeSlots.size > 0)
		{
			int customerNumber = (Integer) freeSlots.random();
			customers[customerNumber].refreshCustomer();
		}
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

		for (int i = 0; i < customers.length; ++i)
		{
			customers[i].draw(game.batch);
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
