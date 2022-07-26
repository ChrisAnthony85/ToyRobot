package model.toy;

import model.interfaces.Movable;
import model.interfaces.Placeable;
import model.interfaces.Reporting;

public abstract class Toy implements Placeable, Movable, Reporting {
    private int x;
    private int y;
    private Direction direction;
    private boolean isPlaced = false;

    public Toy() {
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }


    public boolean isPlaced() {
        return isPlaced;
    }

    public void setPlaced(boolean placed) {
        isPlaced = placed;
    }
}
