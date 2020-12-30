package org.academiadecodigo.gnunas.gfxpaint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Map {

    private final Rectangle map;
    private Rectangle[][] cells;
    static final int CELL_SIZE = 50;

    public Map(int cols , int rows){

        map = new Rectangle(0,0,cols * CELL_SIZE , rows * CELL_SIZE);
        map.draw();
    }

    public void start(){

        cells = new Rectangle[map.getWidth()/CELL_SIZE][map.getHeight()/CELL_SIZE];
        fillCells();
        new EditorController(new Pointer(this), this, new FileEditor(this));
    }

    private void fillCells(){

        for ( int col = 0 ; col < cells.length ; col ++){
            for (int row = 0 ; row < cells[col].length ; row++){
                cells[col][row] = new Rectangle(col * CELL_SIZE, row * CELL_SIZE,CELL_SIZE,CELL_SIZE);
                cells[col][row].draw();
            }
        }
    }

    public int getWidth(){
        return map.getWidth();
    }

    public int getHeight(){
        return map.getHeight();
    }

    public Rectangle getCellAt(int col, int row) {
        return cells[col][row];
    }

    public void clear(){
        for(Rectangle[] col : cells){
            for (Rectangle row : col){
                row.setColor(Color.BLACK);
                row.draw();
            }
        }
    }

    public String saveWithRGB(){

        String saveText = "";

        for( Rectangle[] col : cells){
            for (Rectangle row :col) {
                saveText += row.getColor().getRed() + "x" + row.getColor().getGreen() + "x" + row.getColor().getBlue() + "-";
            }
            saveText = saveText.substring(0,saveText.length()-1);
            saveText += "\n";
        }
        return saveText;

    }

    public void load(String savedFile){
        String [] lines = savedFile.split("\n");
        clear();

        for (int i = 0 ; i < lines.length ; i++){
            String[] squares = lines[i].split("-");
            for (int j = 0; j < squares.length; j++){
                String [] rgb = squares[j].split("x");
                cells[i][j].setColor(new Color(Integer.parseInt(rgb[0]),Integer.parseInt(rgb[1]),Integer.parseInt(rgb[2])));
                if (cells[i][j].getColor().getBlue() != 0 && cells[i][j].getColor().getGreen() != 0 && cells[i][j].getColor().getRed() != 0) {
                    cells[i][j].fill();
                }
            }
        }
    }

}
