package ru.java2;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        func1();
        func2();
    }

    public static void func1(){
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long b = System.currentTimeMillis();
        System.out.println("Время в одном потоке: "+(b-a));
    }

    public static void func2() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        float arr1[] = new float[HALF];
        float arr2[] = new float[HALF];
        System.arraycopy(arr,0, arr1, 0, HALF);
        System.arraycopy(arr,HALF, arr2, 0, HALF);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < HALF; i++) {
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = HALF; i < SIZE; i++) {
                    arr2[i-HALF] = (float)(arr2[i-HALF] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(arr1,0, arr, 0, HALF);
        System.arraycopy(arr2,0, arr, HALF, HALF);
        long b = System.currentTimeMillis();
        System.out.println("Время при разбивке на два потока: "+(b-a));
    }
}
