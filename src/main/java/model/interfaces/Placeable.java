package model.interfaces;

import exceptions.InvalidPlacementException;
import model.toy.Direction;

public interface Placeable {
    void place(int x, int y, Direction direction) throws InvalidPlacementException;
    void remove();
}
