# ToyRobot

Run ToyRobotApplication.java 

Enter commands via Command Line to (P)LACE robot with x,y coordinate and starting direction north, south, east, west; 
(M)OVE robot, (L)EFT to turn left 90 degrees, (R)IGHT to turn right 90 degrees and 
(REP)ORT the current position of the robot. EXIT to exit application. All Commands are case-insensitive.

Possible example of commands and outcome.
=========================================================
Enter Command: Place 1, 2, north
Enter Command: Place 1  2 NORTH
Enter Command: P 1,2 North
Enter Command: Rep
1, 2, NORTH
Enter Command: REPORT
1, 2, NORTH
Enter Command: L
Enter Command: report
1, 2, WEST
Enter Command: M
Enter Command: Report
0, 2, WEST
Enter Command: left
Enter Command: rep
0, 2, SOUTH
Enter Command: Right
Enter Command: move        //invalid will -> fall ignored
Enter command: repORT
0, 2, WEST
Enter Command: exit

Process finished with exit code 0
=========================================================

