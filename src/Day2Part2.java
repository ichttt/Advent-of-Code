/**
 * Created by Tobias on 02.12.2016.
 */
public class Day2Part2 {

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
     * 2= middle
     * 4 = right
     */
    private static int posX;

    /**
     * 0 = Up
     * 2= middle
     * 4 = down
     */
    private static int posY;

    private static void walk() {
        switch (facing) {
            case 0:
                if(posY!=0&&posX==2||posY>1&&(posX==1||posX==3))
                    posY += -1;
                break;
            case 1:
                if(posX!=4&&posY==2||posX<3&&(posY==1||posY==3))
                    posX += 1;
                break;
            case 2:
                if(posY!=4&&posX==2||posY<3&&(posX==1||posX==3))
                    posY += 1;
                break;
            case 3:
                if(posX!=0&&posY==2||posX>1&&(posY==1||posY==3))
                    posX += -1;
                break;
            default:
                throw new IllegalArgumentException("switch error");
        }
    }

    public static void main(String args[]) {
        posX = 0;
        posY = 2;
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
            switch(posY) {
                case 0:
                    System.out.println(1);
                    break;
                case 1:
                    System.out.println(posX+1);
                    break;
                case 2:
                    System.out.println(posX+5);
                    break;
                case 3:
                    if(posX==1)
                        System.out.println("A");
                    else if(posX==2)
                        System.out.println("B");
                    else
                        System.out.println("C");
                    break;
                case 4:
                    System.out.println("D");
            }
        }
    }
}
