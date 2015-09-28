package com.recursivegames.pizzabase;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;

/**
 * Created by Jake on 27/09/2015.
 */
public class Customer {
    private Sprite sprite;
    private Order customerOrder;
    private BitmapFont orderText;
    private BitmapFont ratingText;
    private int rating;
    private boolean served;

    public Customer(PizzaBaseGame game, int custNumber)
    {
        sprite = new Sprite(game.manager.get("customer.png", Texture.class));
        sprite.setPosition(0, (game.viewport.getWorldHeight() * 0.25f) * custNumber);

        //Set served to true so it won't draw and can be refreshed. Not the ideal solution but it'll do for now. -JR
        served = true;

        orderText = new BitmapFont();
        orderText.getData().setScale(3f);

        ratingText = new BitmapFont();
        ratingText.getData().setScale(3f);
    }

    public Order getOrder()
    {
        return customerOrder;
    }

    public int checkOrder(int[] order)
    {
        boolean orderCorrect = customerOrder.CheckOrder(order);

        if(orderCorrect == false)
        {
           rating = 0;
        }

        served = true;
        return rating;
    }

    public int getRating()
    {
        return rating;
    }

    public Sprite getSprite()
    {
        return  sprite;
    }

    public boolean isServed()
    {
        return served;
    }

    public void refreshCustomer()
    {
        customerOrder = new Order(3);
        rating = 5;
        served = false;
    }

    public void draw(SpriteBatch batch)
    {
        if(served == false)
        {
            sprite.draw(batch);
            String orderString = "Order: ";
            for (int i = 0; i < 3; i++)
            {
                orderString += Integer.toString(customerOrder.order[i]) + " ";
            }
            orderText.draw(batch, orderString, sprite.getX() + (sprite.getWidth() * 1.1f), sprite.getY() + sprite.getHeight());

            String ratingString = "Rating: ";
            for (int i = 0; i < rating; i++)
            {
                ratingString += "*";
            }
            ratingText.draw(batch, ratingString, sprite.getX() + (sprite.getWidth() * 1.1f), sprite.getY() + (sprite.getHeight() * 0.5f));
        }
    }
}
