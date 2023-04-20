package xiancheng;

public class p1 {
    public static void main(String[] args) {
        RunnableDemo a = new RunnableDemo("thread_1");
        RunnableDemo b = new RunnableDemo("thread_2");

        a.start();
        b.start();
    }
}


class RunnableDemo implements Runnable{
    private Thread t ;
    private String threadName;

    RunnableDemo(String name){
        threadName=name;
        System.out.println("the name of the thread is "+threadName);
    }


    @Override
    public void run() {
        System.out.println("thread starts running");
        try{
            for( int i = 5 ; i > 0 ; i--){
                System.out.println("thread:"+threadName+","+i);
                Thread.sleep(50);
            }
        }
        catch (InterruptedException e){
            System.out.println("the thread is interupted ");
        }
    }

    public void start(){
        System.out.println(threadName+" start");
        if(t==null){
            t=new Thread(this ,threadName);
            t.start();
        }
    }
}