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

    private static final String path = "R4, R1, L2, R1, L1, L1, R1, L5, R1, R5, L2, R3, L3, L4, R4, R4, R3, L5, L1, R5, R3, L4, R1, R5, L1, R3, L2, R3, R1, L4, L1, R1, L1, L5, R1, L2, R2, L3, L5, R1, R5, L1, R188, L3, R2, R52, R5, L3, R79, L1, R5, R186, R2, R1, L3, L5, L2, R2, R4, R5, R5, L5, L4, R5, R3, L4, R4, L4, L4, R5, L4, L3, L1, L4, R1, R2, L5, R3, L4, R3, L3, L5, R1, R1, L3, R2, R1, R2, R2, L4, R5, R1, R3, R2, L2, L2, L1, R2, L1, L3, R5, R1, R4, R5, R2, R2, R4, R4, R1, L3, R4, L2, R2, R1, R3, L5, R5, R2, R5, L1, R2, R4, L1, R5, L3, L3, R1, L4, R2, L2, R1, L1, R4, R3, L2, L3, R3, L2, R1, L4, R5, L1, R5, L2, L1, L5, L2, L5, L2, L4, L2, R3";
    public static void main(String args[]) {
        String[] split = path.split(",");
        for(int i = 0; i<split.length;i++) {
            if(split[i].startsWith(" "))
                split[i] = split[i].substring(1);

            assert split[i].length() >=2;
            if(split[i].startsWith("R"))
                turnRight();
            else if(split[i].startsWith("L"))
                turnLeft();
            else
                throw new IllegalArgumentException(split[i]);
            walk(Integer.parseInt(split[i].substring(1)));
        }
        
        System.out.println(posX + posY);
    }
}
