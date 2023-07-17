import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceDemoWithFuture_MultipleCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.getProperty("os.name");
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<callabletask> l=
                List.of(new callabletask("Deep"),new callabletask("Deep1"),
                        new callabletask("Deep2"));

        //Future is a promise it waits for task completion
//        Future<String> f=executorService.submit(new callabletask("Deep"));
        List<Future<String>> f_results= executorService.invokeAll(l);
        //can also use invokeAny to invoke the first
        for(Future<String> f:f_results)
            System.out.println(f.get()); //get method waits for the future to complete

//        System.out.println(result);
        System.out.println("Completed Main");
        executorService.shutdown();

    }
}
//class callabletask implements Callable<String>{
//    private String name;
//
//    public callabletask(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String call() throws Exception {
//        Thread.sleep(1000);
//        return "Hello " + name;
//    }
//}
