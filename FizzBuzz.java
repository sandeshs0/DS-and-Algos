public class FizzBuzz {
    private int n;
    private int currentNumber = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz() {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 != 0) {
                System.out.println("Fizz");
                currentNumber++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void buzz() {
        while (currentNumber <= n) {
            if (currentNumber % 3 != 0 && currentNumber % 5 == 0) {
                System.out.println("Buzz");
                currentNumber++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void fizzbuzz() {
        while (currentNumber <= n) {
            if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
                System.out.println("FizzBuzz");
                currentNumber++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void number() {
        while (currentNumber <= n) {
            if (currentNumber % 3 != 0 && currentNumber % 5 != 0) {
                System.out.println(currentNumber);
                currentNumber++;
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 15; // Change n to control the range of numbers
        FizzBuzz fizzBuzz = new FizzBuzz(n);

        Thread fizzThread = new Thread(() -> fizzBuzz.fizz());
        Thread buzzThread = new Thread(() -> fizzBuzz.buzz());
        Thread fizzBuzzThread = new Thread(() -> fizzBuzz.fizzbuzz());
        Thread numberThread = new Thread(() -> fizzBuzz.number());

        fizzThread.start();
        buzzThread.start();
        fizzBuzzThread.start();
        numberThread.start();
    }
}
