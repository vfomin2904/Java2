package ru.java2;

public class Wall implements Barrier{

    private int height;

    public Wall(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean overcomming(int max) {
        if(max<height){
            return false;
        }
        return true;
    }
}
