import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static int bank_account;

    public static void main(String[] args) {
        Adjunction thread1 = new Adjunction();
        Withdrawal thread2 = new Withdrawal();
        thread1.start();
        thread2.start();
    }
}

class Adjunction extends Thread {

    public Adjunction() {
    }

    @Override
    public void run() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 10000000);
        Main.bank_account += randomNum;
    }
}

class Withdrawal extends Thread {

    public Withdrawal() {
    }

    @Override
    public void run() {
        int randomNum = ThreadLocalRandom.current().nextInt(-10000000, -1);
        if (Main.bank_account < Math.abs(randomNum)) {
            System.out.println("Не хватает!");
        } else {
            Main.bank_account += randomNum;
        }
    }
}
