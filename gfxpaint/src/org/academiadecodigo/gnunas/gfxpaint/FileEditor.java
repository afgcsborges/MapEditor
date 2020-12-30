package org.academiadecodigo.gnunas.gfxpaint;

import java.io.*;

public class FileEditor {

    private final Map map;

    public FileEditor(Map map){

        this.map = map;
    }

    public void load(){

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("resources/save"));
            String col;
            String savedFile = "";

            while((col = reader.readLine() )!= null) {
                savedFile += col;
                savedFile += "\n";
            }
            map.load(savedFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(){

        String saveText = map.saveWithRGB();
        BufferedWriter saver = null;
        try {
            saver = new BufferedWriter(new FileWriter("resources/save"));
            saver.write(saveText);
        } catch (IOException e) {
            System.err.println(e);
        }
        finally {
            try {
                if (saver != null) {
                    saver.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
        }

    }

}
