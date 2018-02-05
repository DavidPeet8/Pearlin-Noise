package pearlin.noise;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.*;

public class PearlinNoise extends ApplicationAdapter {
	SpriteBatch batch;
	MySprite Hero;

	@Override
	public void create () {
		batch = new SpriteBatch();
		Hero = new MySprite("badlogic.jpg", 0, 0, 100, 100, Constants.NormalDensity);
		//where do we want to call 0?
        //need to create a grid system, heights from noise should map to a number of blocks high not pixels
        //max min height of terrain generation
        //with set x and y will always produce same number
		System.out.println(Noise.noise(50, 50));
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		for(int i = 0; i < 5; i++){
            System.out.println(Noise.noise(i, 50));
        }

		Hero.SprUpdate();
        HandleInput();

		batch.begin();
		batch.draw(Hero, Hero.fX, Hero.fY);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}

	public void HandleInput(){
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            Hero.fDx = -5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            Hero.dVelY += 2;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            Hero.dVelY += -0.5;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            Hero.fDx = 5;
        }
    }
//recursion check
//	public void SayHI(){
//	    System.out.println("hI i wANt tO diE");
//	    i++;
//	    if(i<10) {
//            SayHI();
//        }else{}
//    }
}
