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

    NotepadConf conf;

    Notepad() {
        createGUI();
        load();
    }

    private void createGUI() {
    }

    /**
     *
     * "설정파일은 [계정]/np.conf"
     *
     * categories.sav
     * #카테고리
     * /노트/yyMMddHHmmss
     *
     * 카테고리는 category [DIR]
     * 노트는 category/yyMMddHHmmss.sav
     *
     */
    private void load() {
        conf = new NotepadConf();

        String Home_DIR = System.getProperty("user.home");

        File conffile = new File(Home_DIR + File.separator + "np.conf");
        try {
            if (conffile == null || !conffile.canRead()) {
                conffile.createNewFile();
            }
            Scanner sc = new Scanner(conffile);
            String category;
            String readline = "";
            String SAV = ":save";
            char SHARP = '#';
            char SHARP_STR = '#';
            int idx = -1;

            while ((readline = sc.nextLine()) != null) {
                idx = readline.indexOf(SAV);
                if (idx > -1 && readline.length() > 6) {// 'C:\' or /home/
                    conf.saveDIR = new File(readline.substring(idx + SAV.length()));
                }
                else {
                    break;
                }
                idx = readline.indexOf(SHARP);
                if (idx > -1 && readline.length() > 1) {
                    category = readline.substring(readline.lastIndexOf('#') + 1);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
