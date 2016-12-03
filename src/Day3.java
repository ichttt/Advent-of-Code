/**
 * Created by Tobias on 03.12.2016.
 */
public class Day3 {
    private static int[] ints = new int[3];
    private static int validCount = 0;
    private static String[] commandList = loadFile.load("Day3");
    public static void main(String args[]) {
        for(String cmd:commandList) {
            String split[] = new String[3];
            split[0] = cmd.substring(2,5);
            split[1] = cmd.substring(7,10);
            split[2] = cmd.substring(12,15);
            for(int i = 0; i<split.length;i++) {
                split[i] = split[i].trim();
                ints[i] = Integer.parseInt(split[i]);
            }
            if(ints[0]+ints[1]>ints[2]&&ints[1]+ints[2]>ints[0]&&ints[2]+ints[0]>ints[1])
                validCount++;
        }
        System.out.println("There are "+validCount+" valid Objects.");
    }
}
