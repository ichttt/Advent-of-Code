package ichttt.challenges;

import ichttt.commons.loadFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 02.12.2016.
 */
public class Day1Part2 {
    /**
     * O = North,
     * 1 = East,
     * 2 = South,
     * 3 = West
     */
    private static int facing = 0;

    private static int posX;
    private static int posY;
    private static boolean found = false;

    private static List<Integer> visitedX = new ArrayList<Integer>();
    private static List<Integer> visitedY = new ArrayList<Integer>();

    private static void turnRight() {
        if(facing==3)
            facing = 0;
        else
            facing++;

        assert 0 <= facing;
        assert facing <= 3;
    }

    private static void turnLeft() {
        if(facing==0) {
            facing =3;
        }
        else
            facing--;

        assert 0 <= facing;
        assert facing <= 3;
    }

    private static boolean checkwon() {
        assert visitedX.size() == visitedY.size();
        for(int i= 0;i<visitedX.size();i++) {
            if(visitedY.get(i)==posY&&visitedX.get(i)==posX) {
                System.out.println("Found. Result: " + (Math.abs(posX)+ Math.abs(posY)));
                found = true;
                return true;
            }
        }
        visitedY.add(posY);
        visitedX.add(posX);
        return false;
    }

    private static void walk(int count) {
        switch (facing) {
            case 0:
                for (int i = 0; i < count; i++) {
                    posY += 1;
                    if(checkwon())
                        break;
                }
                break;
            case 1:
                for (int i = 0; i < count; i++) {
                    posX += 1;
                    if(checkwon())
                        break;
                }
                break;
            case 2:
                for (int i = 0; i < Math.abs(count); i++) {
                    posY += -1;
                    if(checkwon())
                        break;
                }
                break;
            case 3:
                for (int i = 0; i < Math.abs(count); i++) {
                    posX += -1;
                    if(checkwon())
                        break;
                }
                break;
            default:
                throw new IllegalArgumentException("switch error");
        }
    }

    private static final String path = loadFile.load("ichttt.challenges.Day1")[0];
    public static void main(String args[]) {
        String[] split = path.split(",");
        for(String s:split) {
            s = s.trim();

            assert s.length() >=2;
            if(s.startsWith("R"))
                turnRight();
            else if(s.startsWith("L"))
                turnLeft();
            else
                throw new IllegalArgumentException(s);
            walk(Integer.parseInt(s.substring(1)));
            if(found)
                break;
        }
    }
}
