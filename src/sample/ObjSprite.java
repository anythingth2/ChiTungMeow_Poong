package sample;

import javafx.scene.input.KeyCode;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
abstract public class ObjSprite {

    private double x;
    private double y;
    private boolean isMovable;


    public ObjSprite() {
        super();
        isMovable=checkMovable();
    }


    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    abstract public boolean checkMovable();


}
