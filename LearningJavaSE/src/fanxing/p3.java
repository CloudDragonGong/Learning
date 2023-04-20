package fanxing;

public class p3<T> {
    T x;

    public void set(T x) {
        this.x = x;
    }


    public T get() {
        return this.x;
    }


    public static void main(String[] args) {
        p3<Integer> a = new p3<>();
        a.set(new Integer(100));
        a.set(100);
        System.out.println(a.get());

        p3<String> b = new p3<>();
        b.set(new String("yunlong"));
        b.set("yunlong");
        System.out.println(b.get());

    }

}
