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

	public Order(int numberOfItems)
	{
		order = new int[numberOfItems];

		for (int i = 0; i < order.length; ++i)
		{
			order[i] = random.nextInt(5); //number between 0 and 4
			Gdx.app.log("order", "order " + order[i]);
		}
	}

	public boolean CheckOrder(int[] o)
	{
		Extensions.BubbleSort(o);
		Extensions.BubbleSort(order);


		boolean toCheck = true;
		for (int i = 0; i < order.length; ++i)
		{
			if (order[i] != o[i])
			{
				toCheck = false;
			}
		}

		return toCheck;
	}
}
