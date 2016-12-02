import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 02.12.2016.
 */
public class loadFile {
    private static String path = System.getProperty("user.home") + "\\AdventofCode\\";
    public static String[] load(String file) {
        String line;
        List<String> strings = new ArrayList<String>();
        String[] s = null;
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(path + file + ".txt"));

            while ((line = bf.readLine()) != null) {
                strings.add(line);
            }
            s = new String[strings.size()];
            for (int i = 0; i < strings.size(); i++)
                s[i] = strings.get(i);
            return s;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("An IO Exception has occured!");
            System.exit(0);
        }
        finally {
            try {
                bf.close();
            } catch (Exception e) {}
        }
        return s;
    }
}