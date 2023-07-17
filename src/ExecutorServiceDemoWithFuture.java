import java.util.concurrent.*;

public class ExecutorServiceDemoWithFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        //Future is a promise it waits for task completion
        Future<String> f=executorService.submit(new callabletask("Deep"));
        System.out.println("Started Thread");
        String result=f.get(); //get method waits for the future to complete

        System.out.println(result);
        System.out.println("Completed Main");
        executorService.shutdown();

    }
}
class callabletask implements Callable<String>{
    private String name;

    public callabletask(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hello " + name;
    }
}
