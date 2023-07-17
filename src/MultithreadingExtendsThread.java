public class MultithreadingExtendsThread {
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

        A1 a=new A1();
        B1 b=new B1();
        a.start();
        b.start();
    }

}
class A1 extends Thread{
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
class B1 extends Thread{
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