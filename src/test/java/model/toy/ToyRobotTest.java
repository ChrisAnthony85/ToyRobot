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

        assertEquals(toyRobot.getX(), 1);
        assertEquals(toyRobot.getY(), 3);
        assertEquals(toyRobot.getDirection(), Direction.NORTH);
    }

    @Test
    void placeAgain() {
        toyRobot.place(0,0, Direction.EAST);
        toyRobot.place(4,4, Direction.WEST);

        assertEquals(toyRobot.getX(), 4);
        assertEquals(toyRobot.getY(), 4);
        assertEquals(toyRobot.getDirection(), Direction.WEST);
    }
    @Test
    void placeOnInvalidSquare() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.place(6,6, Direction.EAST);

        assertEquals(toyRobot.getX(), 0);
        assertEquals(toyRobot.getY(), 0);
        assertEquals(toyRobot.getDirection(), Direction.NORTH);
    }

    @Test
    void moveRemoved() {
        toyRobot.place(0,0, Direction.EAST);
        toyRobot.remove();

        toyRobot.move();
        assertEquals(toyRobot.getX(), -1);
        assertEquals(toyRobot.getY(), -1);
        assertEquals(toyRobot.getDirection(), Direction.NONE);
    }

    @Test
    void move() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.move();

        assertEquals(toyRobot.getX(), 0);
        assertEquals(toyRobot.getY(), 1);
        assertEquals(toyRobot.getDirection(), Direction.NORTH);
    }

    @Test
    void moveNoSquare() {
        toyRobot.place(0,4, Direction.NORTH);
        toyRobot.move();

        assertEquals(toyRobot.getX(), 0);
        assertEquals(toyRobot.getY(), 4);
        assertEquals(toyRobot.getDirection(), Direction.NORTH);
    }

    @Test
    void turnRight() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.turnRight();

        assertEquals(toyRobot.getX(), 0);
        assertEquals(toyRobot.getY(), 0);
        assertEquals(toyRobot.getDirection(), Direction.EAST);
    }

    @Test
    void turnRightUnplaced() {
        toyRobot.remove();
        toyRobot.turnRight();
        assertEquals(toyRobot.getX(), -1);
        assertEquals(toyRobot.getY(), -1);
        assertEquals(toyRobot.getDirection(), Direction.NONE);

    }

    @Test
    void turnLeftUnplaced() {
        toyRobot.remove();
        toyRobot.turnLeft();
        assertEquals(toyRobot.getX(), -1);
        assertEquals(toyRobot.getY(), -1);
        assertEquals(toyRobot.getDirection(), Direction.NONE);
    }

    @Test
    void turnLeft() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.turnLeft();

        assertEquals(toyRobot.getX(), 0);
        assertEquals(toyRobot.getY(), 0);
        assertEquals(toyRobot.getDirection(), Direction.WEST);
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

        assertEquals(toyRobot.getX(), 2);
        assertEquals(toyRobot.getY(), 4);
        assertEquals(toyRobot.getDirection(), Direction.EAST);
    }

    @Test
    void testExample1() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.move();
        toyRobot.report();

        assertEquals(toyRobot.getX(), 0);
        assertEquals(toyRobot.getY(), 1);
        assertEquals(toyRobot.getDirection(), Direction.NORTH);
    }

    @Test
    void testExample2() {
        toyRobot.place(0,0, Direction.NORTH);
        toyRobot.turnLeft();
        toyRobot.report();

        assertEquals(toyRobot.getX(), 0);
        assertEquals(toyRobot.getY(), 0);
        assertEquals(toyRobot.getDirection(), Direction.WEST);
    }

    @Test
    void testExample3() {
        toyRobot.place(1, 2, Direction.EAST);
        toyRobot.move();
        toyRobot.move();
        toyRobot.turnLeft();
        toyRobot.move();
        toyRobot.report();

        assertEquals(toyRobot.getX(), 3);
        assertEquals(toyRobot.getY(), 3);
        assertEquals(toyRobot.getDirection(), Direction.NORTH);
    }
}