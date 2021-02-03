package ru.java2;

public class Main {

    public static void main(String[] args) {
        String[][] arr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
               {"13", "14", "15", "16"}
        };

        int sum = 0;
        try {
            System.out.println("Сумма = "+myFunc(arr));
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.println("Не удалось рассчитать сумму");
        }
        System.out.println("End");
    }

    public static int myFunc(String[][] arr) throws MyArraySizeException, MyArrayDataException{
        int sum = 0;
        if(arr.length != 4){
            throw new MyArraySizeException("Не верный размер массива");
        } else{
            for (int i = 0; i < arr.length; i++){
                if(arr[i].length != 4){
                    throw new MyArraySizeException("Не верный размер массива");
                }
            }
        }


        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr.length; j++) {
                try{
                    sum += Integer.parseInt(arr[i][j]);
                }catch(NumberFormatException e){
                    throw new MyArrayDataException("Элемент arr["+i+"]["+j+"] не является числом");
                }
            }
        }
        return sum;
    }
}
