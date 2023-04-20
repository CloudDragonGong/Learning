package xiancheng;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class p3 implements Callable<Integer> {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        p3 a = new p3();

        for (int i = 0; i < 3; i++) {
            //试着将这条语句放在循环体外部，你会看到不同的结果
            FutureTask<Integer> b = new FutureTask<>(a);

            Thread.sleep(1000);

            System.out.println("the NO." + (i + 1) + "thread start :");
            new Thread(b, "a thread that has return value").start();

            try {
                System.out.println("the return is " + b.get());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        Random x = new Random();
        int randomValue = x.nextInt(100);
        for (int i = 0; i < randomValue; i++) {
            sum += i;
        }
        return sum;
    }
}
