package ichttt.challenges;

import ichttt.commons.loadFile;

/**
 * Created by Tobias on 02.12.2016.
 */
public class Day1 {
    /**
     * O = North,
     * 1 = East,
     * 2 = South,
     * 3 = West
     */
    private static int facing = 0;

    private static int posX;
    private static int posY;

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

    private static void walk(int i) {
        switch (facing) {
            case 0:
                posY += i;
                break;
            case 1:
                posX += i;
                break;
            case 2:
                posY += -i;
                break;
            case 3:
                posX += -i;
                break;
            default:
                throw new IllegalArgumentException("switch error");
        }
    }

    private static final String path = loadFile.loadFirstLine("Day1");
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
        }
        
        System.out.println(Math.abs(posX) + Math.abs(posY));
    }
}
