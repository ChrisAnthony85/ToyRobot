package model.movement;

import java.util.Set;

public class PlayableArea {
    private Set<PlaySquare> squares;

    public PlayableArea(Set<PlaySquare> squares) {
        this.squares = squares;
    }

    public boolean contains(PlaySquare square) {
        return squares.contains(square);
    }

    //we can customize the play area by changing playable squares
    public Set<PlaySquare> getSquares() {
        return squares;
    }

    public void setSquares(Set<PlaySquare> squares) {
        this.squares = squares;
    }


}
