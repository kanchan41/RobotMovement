package com.robot.java;

import java.util.HashMap;

public class RobotMovement {
    public static void main(String[] args) {
        finalMovement(1, 2, "N", "PQPQPQPQQ");
        finalMovement(3, 3, "E", "QQRQQRQRRQ");
    }

    private static HashMap<String, Integer[]> map = new HashMap<String, Integer[]>();

    static {
        map.put("N", new Integer[]{0, 1});
        map.put("S", new Integer[]{0, -1});
        map.put("E", new Integer[]{1, 0});
        map.put("W", new Integer[]{-1, 0});
    }

    public static void finalMovement(int x, int y, String dir, String path) {
        String currdir = dir;
        int currXPos = x;
        int currYPos = y;
        int move = path.length();
        for (int i = 0; i < move; i++) {
            switch (path.charAt(i)) {
                case 'N':
                case 'S':
                case 'E':
                case 'W':
                    currdir = String.valueOf(path.charAt(i));
                    break;
                case 'Q':
                    currXPos += map.get(currdir)[0];
                    currYPos += map.get(currdir)[1];
                    break;
                case 'P':
                    if (currdir.equals("N")) {
                        currdir = "W";
                    } else if (currdir.equals("S")) {
                        currdir = "E";
                    } else if (currdir.equals("E")) {
                        currdir = "N";
                    } else if (currdir.equals("W")) {
                        currdir = "S";
                    }
                    break;
                case 'R':
                    if (currdir.equals("N")) {
                        currdir = "E";
                    } else if (currdir.equals("S")) {
                        currdir = "W";
                    } else if (currdir.equals("E")) {
                        currdir = "S";
                    } else if (currdir.equals("W")) {
                        currdir = "N";
                    }
                default:
                    break;
            }
        }
        System.out.println(currXPos + " " + currYPos + " " + currdir);
    }
}