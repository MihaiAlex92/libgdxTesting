package com.gradle.snake.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Snake extends ApplicationAdapter {
    SpriteBatch batch;/*SpriteBatch  means just a batch of
sprites scattered in some fashion on the game screen giving a feeling of Game!*/
    Texture body;
    OrthographicCamera camera;/*Do not worry about this now.just use it*/
    ArrayList<Vector2> snake;/*We are maintaining the snake body in this*/
    /*Vector2 is a class which has an x, y coordinate and some nice functions to manage the same*/
    @Override
    public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        snake= new ArrayList<Vector2>();

/*Initially we are initializing four body pieces.
Right now there is no distinction between the snake head and body for simplicity.*/
        snake.add(new Vector2(480/2,800/2));
        snake.add(new Vector2(480/2+20,800/2));
        snake.add(new Vector2(480/2+40,800/2));
        snake.add(new Vector2(480/2+60,800/2));
        body = new Texture(Gdx.files.internal("body.png"));/*Get the image of the snake body 20*20 in the Ram, for fast rendering.
Never keep such initializations in the render method.
Game will crash since then it will access the hard disk every time reducing the efficiency.*/

    }
    @Override
    public void render () {/*this method is called first after calling create method, Until a pause event happens
or an exit event happens this method is called for every frame rendering.
This means that this is the main method which updates the game every frame. */
        Gdx.gl.glClearColor(1, 0.2f, 1, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);/*Above 2 functions clear the color and set a standard color*/
        camera.update();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();/*Starts Rendering(drawing the images on the game area per frame*/
        batch.draw(body, snake.get(0).x, snake.get(0).y);

        batch.draw(body, snake.get(1).x, snake.get(1).y);
        batch.draw(body, snake.get(2).x, snake.get(2).y);
        batch.draw(body, snake.get(3).x, snake.get(3).y);
        batch.end();

    }
    public void dispose()
    {
        batch.dispose();/*Very important to dispose the batch, else can result in memory leaks.*/
    }
}