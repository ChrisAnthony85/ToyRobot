import model.toy.Direction;
import model.toy.ToyRobot;
import util.ToyRobotAppUtil;

import java.util.Arrays;
import java.util.Scanner;

public class ToyRobotApplication {
    public static void main(String[] args) {
        startProcess();
    }

    private static void startProcess() {
        Scanner scanner = new Scanner(System.in);

        ToyRobot toyRobot = new ToyRobot();
        toyRobot.setArea(ToyRobotAppUtil.getDefaultSquareArea());

        String input;

        do {
            System.out.print("Enter Command: ");
            input = scanner.nextLine();
            processCommand(input.toUpperCase(), toyRobot);
        }
        while (!input.equalsIgnoreCase("EXIT"));
    }

    private static void processCommand(String input, ToyRobot toyRobot) {
        try {
            if (input.startsWith("P")) {  //Place or Pl or P will work
                //divide the string into 4  <place, x, y, direction>
                String[] strings = Arrays.stream(input.split("[\\s+;:,]"))
                        .filter(str -> str.trim().length() > 0).toArray(String[]::new);
                int x = Integer.parseInt(strings[1]);
                int y = Integer.parseInt(strings[2]);
                Direction direction = Direction.valueOf(strings[3]);

                toyRobot.place(x, y, direction);
            }
            else if (input.equals("M") || input.equals("MOVE")) {
                toyRobot.move();
            }
            else if (input.equals("L") || input.equals("LEFT")) {
                toyRobot.turnLeft();
            }
            else if (input.equals("R") || input.equals("RIGHT")) {
                toyRobot.turnRight();
            }
            else if (input.startsWith("RE")) { //re, rep, report will work
                toyRobot.report();
            }
        } catch (Exception e) {
            System.out.println("Invalid Command. Please Try again. ");
        }


    }
}
