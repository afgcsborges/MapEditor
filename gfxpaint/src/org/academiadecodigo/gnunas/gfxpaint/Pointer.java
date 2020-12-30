package org.academiadecodigo.gnunas.gfxpaint;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pointer {

    private final Rectangle pointer;
    private final Map map;
    private boolean painting;

    public Pointer (Map map) {

        this.map = map;

        pointer = new Rectangle(0,0, Map.CELL_SIZE, Map.CELL_SIZE);
        pointer.setColor(Color.BLUE);
        pointer.fill();

    }

    public void move(Direction direction){

        if(!canIMoveTo(direction)){
            return;
        }
        pointer.translate(direction.x,direction.y);

        if(painting){
            paint();
        }
    }

    // TODO HOLY SH*T
    private boolean canIMoveTo(Direction direction){

        int nextX = pointer.getX()+direction.x;
        int nextY = pointer.getY()+direction.y;

        return (nextX >=0 && nextX < map.getWidth())
                && (nextY >=0 && nextY < map.getHeight());
    }

    public void paint(){

        Rectangle currentCell = map.getCellAt(pointerPosition()[0],pointerPosition()[1]);
        if (currentCell.getColor() != Color.BLACK){

            currentCell.setColor(Color.BLACK);
            currentCell.draw();
            return;
        }
        currentCell.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
        currentCell.fill();
    }

    private int[] pointerPosition() {

        int col = (pointer.getX() / Map.CELL_SIZE);
        int row = (pointer.getY() / Map.CELL_SIZE);
        return new int[] {col,row};
    }

    public void setPainting( boolean painting){
        this.painting = painting;
    }

    public enum Direction {
        UP(0,-Map.CELL_SIZE),
        DOWN(0,Map.CELL_SIZE),
        LEFT(-Map.CELL_SIZE,0),
        RIGHT(Map.CELL_SIZE,0);

        public final int x;
        public final int y;

        Direction(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

}
