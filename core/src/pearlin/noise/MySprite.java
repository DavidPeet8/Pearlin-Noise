package pearlin.noise;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class MySprite extends Sprite {
    public float fX, fY, fDx;
    public float dVelY = 0;
    public double density;
    MySprite(String sFile, float fX, float fY, float fW, float fH, double density){
        super( new Texture(sFile));
        setPosition(fX, fY);
        setSize(fW, fH);

        this.density = density;
    }

    public void SprUpdate(){
        fDx = 0;
        gravity(density);
        boundscheck();
        move();
        //animations, etc?
        //put moving in here too?
    }

    public void move(){
        fX = getX();
        setX(getX() + fDx);
        fY = getY();
        setY(getY() + dVelY);

    }

    public void boundscheck(){
        if (getY()< 0){
            setY(0);
        }
    }

    public void gravity(double density){
        dVelY+= Constants.GravConstant * density;
    }
}
