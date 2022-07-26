package model.toy;

import model.movement.PlaySquare;
import model.movement.PlayableArea;

public class ToyRobot extends Toy {

    private PlayableArea area;

    public ToyRobot() {
        super();
    }

    @Override
    public void place(int x, int y, Direction direction) {
        //check if placeable in area
        if(this.getArea().contains(new PlaySquare(x, y))) {
            this.setX(x);
            this.setY(y);
            this.setDirection(direction);
            this.setPlaced(true);
        }
    }

    @Override
    public void remove() {
        this.setX(-1);
        this.setY(-1);
        this.setDirection(Direction.NONE);
        this.setPlaced(false);
    }


    @Override
    public void move() {
        if(!this.isPlaced()) {
            return;
        }

        PlaySquare targetSquare = new PlaySquare(this.getX(), this.getY());
        if(this.getDirection() == Direction.NORTH) {
            targetSquare.setY(targetSquare.getY() + 1);
            if(this.getArea().contains(targetSquare)) {
                this.setY(this.getY() + 1);
            }
        }
        else if(this.getDirection() == Direction.SOUTH) {
            targetSquare.setY(targetSquare.getY() - 1);
            if(this.getArea().contains(targetSquare)) {
                this.setY(this.getY() - 1);
            }

        }
        else if(this.getDirection() == Direction.EAST) {
            targetSquare.setX(targetSquare.getX() + 1);
            if(this.getArea().contains(targetSquare)) {
                this.setX(this.getX() + 1);
            }

        }
        else if(this.getDirection() == Direction.WEST) {
            targetSquare.setX(targetSquare.getX() - 1);
            if(this.getArea().contains(targetSquare)) {
                this.setX(this.getX() - 1);
            }

        }
    }

    @Override
    public void turnLeft() {
        if(this.isPlaced()) {
            switch (this.getDirection()) {
                case NORTH:
                    this.setDirection(Direction.WEST);
                    break;
                case SOUTH:
                    this.setDirection(Direction.EAST);
                    break;
                case EAST:
                    this.setDirection(Direction.NORTH);
                    break;
                case WEST:
                    this.setDirection(Direction.SOUTH);
                    break;
            }
        }
    }

    @Override
    public void turnRight() {
        if(this.isPlaced()) {
            switch (this.getDirection()) {
                case NORTH:
                    this.setDirection(Direction.EAST);
                    break;
                case SOUTH:
                    this.setDirection(Direction.WEST);
                    break;
                case EAST:
                    this.setDirection(Direction.SOUTH);
                    break;
                case WEST:
                    this.setDirection(Direction.NORTH);
                    break;
            }
        }
    }


    @Override
    public void report() {
        if(this.isPlaced()) {
            System.out.println(this.getX() + ", " + this.getY() + ", " + this.getDirection());
        }
    }

    public PlayableArea getArea() {
        return area;
    }

    public void setArea(PlayableArea area) {
        this.area = area;
    }
}
