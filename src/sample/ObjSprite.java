package sample;

import javafx.scene.input.KeyCode;

/**
 * Created by ChiChaChai on 29/3/2560.
 */
abstract public class ObjSprite {

    private double x;
    private double y;


    private double widthSprite;
    private double heightSprite;

    private boolean isMovable;


    public ObjSprite() {
        super();
        isMovable = checkMovable();
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

    public double getWidthSprite() {
        return widthSprite;
    }

    public double getHeightSprite() {
        return heightSprite;
    }

    public void setWidthSprite(double widthSprite) {
        this.widthSprite = widthSprite;
    }

    public void setHeightSprite(double heightSprite) {
        this.heightSprite = heightSprite;
    }

    public boolean isMovable() {
        return isMovable;
    }

    abstract public boolean checkMovable();


}
