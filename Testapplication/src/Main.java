

public class Main {
    public static void main(String[] args) {
        Myclass cls = new Myclass();

        Thread t1 = new Thread(new Producer(cls));
        Thread t2 = new Thread(new Consumer(cls));

        t1.run();
        t2.run();
    }
}

class Producer implements Runnable {
    Myclass myclass;

    Producer(Myclass myclass) {
        this.myclass = myclass;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Producer");
                //myclass.setI(7);
                Thread.sleep(2000);
            }
                myclass.notify();

        } catch (Exception e) {
            System.out.println("Producer interrupted");
        }
    }
}

class Consumer implements Runnable {
    Myclass myclass;

    Consumer(Myclass myclass) {
        this.myclass = myclass;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Consumer");
                //System.out.println(myclass.getI());
                Thread.sleep(2000);
            }
                myclass.notify();

        } catch (Exception e) {
            System.out.println("Consumer interrupted");
        }
    }
}

class Myclass {
    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}