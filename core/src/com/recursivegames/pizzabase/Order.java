package com.recursivegames.pizzabase;

import com.badlogic.gdx.Gdx;

import java.util.Random;

/**
 * Package : com.recursivegames.pizzabase
 * Author : Matthew Hurst
 * Created : 24/09/2015 - 22:20
 */
public class Order
{
	public int[] order;
	private Random random = new Random();
	public boolean solved = false;

	public Order()
	{
		order = new int[3];

		for (int i = 0; i < order.length; ++i)
		{
			order[i] = random.nextInt(6); //number between 0 and 5
			Gdx.app.log("order", "order" + i);
		}
	}

	public boolean CheckOrder(int[] o)
	{
		boolean toCheck = true;
		for (int i = 0; i < order.length; ++i)
		{
			for (int j = 0; j < o.length; ++j)
			{
				if (order[i] == o[j])
				{
					continue;
				}
			}
		}

		return toCheck;
	}
}
