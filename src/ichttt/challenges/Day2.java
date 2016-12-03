package ichttt.challenges;

import ichttt.commons.loadFile;

/**
 * Created by Tobias on 02.12.2016.
 */
public class Day2 {

    private static final String[] commandList = loadFile.load("Day2");

    /**
     * O = North,
     * 1 = East,
     * 2 = South,
     * 3 = West
     */
    private static int facing;

    /**
     * 0 = left
     * 1= middle
     * 2 = right
     */
    private static int posX;
    /**
     * 0 = Up
     * 1= middle
     * 2 = down
     */
    private static int posY;

    private static void walk() {
        switch (facing) {
            case 0:
                if(posY!=0)
                    posY += -1;
                break;
            case 1:
                if(posX!=2)
                    posX += 1;
                break;
            case 2:
                if(posY!=2)
                    posY += 1;
                break;
            case 3:
                if(posX!=0)
                    posX += -1;
                break;
            default:
                throw new IllegalArgumentException("switch error");
        }
    }

    public static void main(String args[]) {
        posX = 1;
        posY = 1;
        for(String s1:commandList) {
            char[] commandChar = s1.toCharArray();
            for (char c : commandChar) {
                String s = c + "";
                switch (s) {
                    case "U":
                        facing = 0;
                        break;
                    case "R":
                        facing = 1;
                        break;
                    case "D":
                        facing = 2;
                        break;
                    case "L":
                        facing = 3;
                        break;
                    default:
                        throw new IllegalArgumentException(s);
                }
                walk();

            }
            System.out.println(posX + posY * 3 + 1);
        }
    }
}
