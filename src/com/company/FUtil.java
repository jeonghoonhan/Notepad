package com.company;

import java.io.*;

public class FUtil {

    public static int read(String path_and_file, String output) {
        return read(new File(path_and_file), output);
    }

    static BufferedReader bfreader;

    public static int read(File file, String output) {
        try {
            bfreader = new BufferedReader(new FileReader(file));
            StringBuilder buf = new StringBuilder();
            String readline = "";
            String NL = "\n";

            while ((readline = bfreader.readLine()) != null) {
                buf.append(readline).append(NL);
            }
            buf.deleteCharAt(buf.length()-1);
            output = buf.toString();

            bfreader.close();
            return 0;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
