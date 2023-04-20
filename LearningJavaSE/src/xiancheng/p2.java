package xiancheng;

public class p2 extends Thread{
    public static void main(String[] args) {
        p2 thread_1=new p2("thread_1");
        p2 thread_2=new p2("thread_2");

        thread_1.start();
        thread_2.start();
    }

    private final String name;
    private Thread thread;
    p2(String name){
        this.name=name;
    }
    public void run(){
        try{
            for (int i = 10; i > 0; i--) {
                System.out.println("thread ("+name+")sleep"+i);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("the thread is interrupted by something else");
        }
        System.out.println("run is down");
    }
    public void start(){
        this.thread=new Thread(this,this.name);
        System.out.println("the thread is created");
        thread.start();
    }
}
