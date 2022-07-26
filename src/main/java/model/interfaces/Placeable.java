package model.interfaces;

import model.toy.Direction;

public interface Placeable {
    void place(int x, int y, Direction direction);
    void remove();
}
