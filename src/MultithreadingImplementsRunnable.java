public class MultithreadingImplementsRunnable {
    public static void main(String[] args) {

//        System.out.printf("Hello and welcome!");
//
//        // Press Ctrl+R or click the green arrow button in the gutter to run the code.
//        for (int i = 1; i <= 5; i++) {
//
//            // Press Ctrl+D to start debugging your code. We have set one breakpoint
//            // for you, but you can always add more by pressing Cmd+F8.
//            System.out.println("i = " + i);
//        }
//
//        ArrayList<String> a=new ArrayList<String>();
//        String[] arr="Hello and welcome!".split(" ");
//        a=new ArrayList<>(List.of(arr));
//        System.out.println(a);

        A2 a=new A2();
        B2 b=new B2();
        Thread t1 =new Thread(a);
        Thread t2 =new Thread(b);
        t1.start();
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
    }

}
class A2 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("a");
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class B2 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("b");
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}