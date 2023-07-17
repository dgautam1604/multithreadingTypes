public class MultithreadingWithLambdaSynchronised {
    public static void main(String[] args) throws InterruptedException {
        counter c =new counter();
        Runnable a=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<500;i++){
//                    System.out.println("a");
                    c.increment();
//
                }
            }
        };
        Runnable b=()->{
                for(int i=0;i<500;i++){
//                    System.out.println("b");
                   c.increment();
                }
            }
        ;
        Thread t1 =new Thread(a,"Yo Thread");
        Thread t2 =new Thread(b);
//        System.out.println(t1.getName());
//        System.out.println(t2.getName());
        t1.start();
        try{
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();
        t1.join();//it joins normal threads to wait and join with main thread
        t2.join();
        System.out.println(c.count);
    }

}
class counter{
    int count;
    public synchronized void increment(){
        count++;
    }
}