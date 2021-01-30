package ru.java2;

public class Track implements Barrier{

    private int length;

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean overcomming(int max) {
        if(max<length){
            return false;
        }
        return true;
    }
}
