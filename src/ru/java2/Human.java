package ru.java2;

public class Human implements RunJumpable{

    private int maxDist;
    private int maxHeight;
    private String name;
    private boolean active = true;

    public Human(int maxDist, int maxHeight, String name) {
        this.maxDist = maxDist;
        this.maxHeight = maxHeight;
        this.name = name;
    }

    @Override
    public void run(Track barrier){
        if(!active){
            return;
        }
        if(barrier.overcomming(this.maxDist)){
            System.out.println("Человек "+name+" пробежал "+barrier.getLength()+" метров");
        }
        else{
            System.out.println("Человек "+name+" не смог пробежать "+barrier.getLength()+" метров");
            active = false;
        }
    }

    @Override
    public void jump(Wall barrier){
        if(!active){
            return;
        }
        if(barrier.overcomming(this.maxHeight)){
            System.out.println("Человек "+name+" перепрыгнул "+barrier.getHeight()+" метров");
        }
        else{
            System.out.println("Человек "+name+" не смог перепрыгнуть "+barrier.getHeight()+" метров");
            active = false;
        }
    }
}
