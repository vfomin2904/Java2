package ru.java2;

public class Main {

    public static void main(String[] args) {

        RunJumpable[] members = {
                new Human(20, 3, "Иван"),
                new Cat(10, 5, "Мурзик"),
                new Robot(5, 2, "Бот"),
                new Human(15, 4, "Петр"),
                new Cat(10, 3, "Пушок"),
                new Robot(4, 2, "Нотик"),
                new Cat(30, 5, "Том")
        };

        Barrier[] barriers = {
                new Wall(2),
                new Track(3),
                new Wall(3),
                new Track(5),
                new Wall(4),
                new Track(10),
                new Wall(5),
                new Track(20)
        };


        for (Barrier barrier : barriers) {
            for (RunJumpable memb : members) {
                if (barrier instanceof Track) {
                    memb.run((Track) barrier);
                } else {
                    memb.jump((Wall) barrier);
                }
            }
            System.out.println();
        }

    }
}
