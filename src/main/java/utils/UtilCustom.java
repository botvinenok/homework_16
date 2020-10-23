package utils;

import java.util.Random;

public class UtilCustom {
    public static int random(){
        Random rand  = new Random();
        return rand.nextInt();
    }

    public static void sleepSecond(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
