package model.toy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import util.ToyRobotAppUtil;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ToyRobotTest {

    private ToyRobot toyRobot;

    @BeforeAll
    void setup() {
        toyRobot = new ToyRobot();
        toyRobot.setArea(ToyRobotAppUtil.getDefaultSquareArea());
    }

    @Test
    void place() {
        toyRobot.place(1,3, Direction.NORTH);

        assertEquals(1, toyRobot.getX());
        assertEquals(3, toyRobot.getY());
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }

    @Test
    void placeAgain() {
        toyRobot.place(0,0, Direction.EAST);
        toyRobot.place(4,4, Direction.WEST);

        assertEquals(4,toyRobot.getX());
        assertEquals(4,toyRobot.getY());
        assertEquals(Direction.WEST, toyRobot.getDirection());
    }
    @Test
    void placeOnInvalidSquare() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.place(6,6, Direction.EAST);

        assertEquals(0, toyRobot.getX());
        assertEquals(0, toyRobot.getY());
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }

    @Test
    void moveRemoved() {
        toyRobot.place(0,0, Direction.EAST);
        toyRobot.remove();

        toyRobot.move();
        assertEquals(-1, toyRobot.getX());
        assertEquals(-1, toyRobot.getY());
        assertEquals(Direction.NONE, toyRobot.getDirection());
    }

    @Test
    void move() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.move();

        assertEquals(0, toyRobot.getX());
        assertEquals(1, toyRobot.getY());
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }

    @Test
    void moveNoSquare() {
        toyRobot.place(0,4, Direction.NORTH);
        toyRobot.move();

        assertEquals(0, toyRobot.getX());
        assertEquals(4, toyRobot.getY());
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }

    @Test
    void turnRight() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.turnRight();

        assertEquals(0, toyRobot.getX());
        assertEquals(0, toyRobot.getY());
        assertEquals(Direction.EAST, toyRobot.getDirection());
    }

    @Test
    void turnRightUnplaced() {
        toyRobot.remove();
        toyRobot.turnRight();
        assertEquals(-1, toyRobot.getX());
        assertEquals(-1, toyRobot.getY());
        assertEquals(Direction.NONE, toyRobot.getDirection());

    }

    @Test
    void turnLeftUnplaced() {
        toyRobot.remove();
        toyRobot.turnLeft();
        assertEquals(-1, toyRobot.getX());
        assertEquals(-1, toyRobot.getY());
        assertEquals(Direction.NONE, toyRobot.getDirection());
    }

    @Test
    void turnLeft() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.turnLeft();

        assertEquals(0, toyRobot.getX());
        assertEquals(0, toyRobot.getY());
        assertEquals(Direction.WEST, toyRobot.getDirection());
    }

    @Test
    void movesAndTurnsMixedWithInvalidCommands() {
        toyRobot.place(0,4, Direction.WEST);
        toyRobot.move(); //invalid ignore
        toyRobot.turnLeft();
        toyRobot.move();
        toyRobot.turnLeft();
        toyRobot.move();
        toyRobot.turnLeft();
        toyRobot.move();
        toyRobot.report();
        toyRobot.move();
        toyRobot.report();
        toyRobot.turnRight();
        toyRobot.move();

        assertEquals(2, toyRobot.getX());
        assertEquals(4, toyRobot.getY());
        assertEquals(Direction.EAST, toyRobot.getDirection());
    }

    @Test
    void testExample1() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.move();
        toyRobot.report();

        assertEquals(0, toyRobot.getX());
        assertEquals(1, toyRobot.getY());
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }

    @Test
    void testExample2() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.turnLeft();
        toyRobot.report();

        assertEquals(0, toyRobot.getX());
        assertEquals(0, toyRobot.getY());
        assertEquals(Direction.WEST, toyRobot.getDirection());
    }

    @Test
    void testExample3() {
        toyRobot.place(1, 2, Direction.EAST);
        toyRobot.move();
        toyRobot.move();
        toyRobot.turnLeft();
        toyRobot.move();
        toyRobot.report();

        assertEquals(3, toyRobot.getX());
        assertEquals(3, toyRobot.getY());
        assertEquals(Direction.NORTH, toyRobot.getDirection());
    }
}