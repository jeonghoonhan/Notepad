package com.company;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Notepad extends JFrame {

    public static void main(String[] args) {
        new Notepad();
    }

    Notepad() {
        createGUI();
        load();
    }

    private void createGUI() {
    }

    /**
     * categories.sav
     * #카테고리
     * /노트/yyMMddHHmmss
     *
     * 카테고리는 category [DIR]
     * 노트는 category/yyMMddHHmmss.sav
     *
     * "설정파일은 [계정]/np.conf"
     */
    private void load() {
        String Home_DIR = System.getProperty("user.home");

        File conffile = new File(Home_DIR + File.separator + "np.conf");
        try {
            if (conffile == null || !conffile.canRead()) {
                conffile.createNewFile();
            }
            Scanner sc = new Scanner(conffile);
            String category;
            String readline = "";

            while ((readline = sc.nextLine()) != null) {
                if (readline.startsWith("#")) {
                    category = readline;
                } else {

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
