package com.recursivegames.pizzabase;

/**
 * Package : com.recursivegames.pizzabase
 * Author : Matthew Hurst
 * Created : 26/09/2015 - 22:34
 */
public class Extensions
{
	public static void BubbleSort(int[] toSort)
	{
		for (int i = 0; i < toSort.length-1; ++i)
		{
			for (int j = 1; j < toSort.length; ++j)
			{
				if (toSort[i] < toSort[j])
				{
					int temp = toSort[i];
					toSort[i] = toSort[j];
					toSort[j] = temp;
				}
			}
		}
	}
}
