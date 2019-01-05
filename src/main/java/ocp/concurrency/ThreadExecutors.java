package ocp.concurrency;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadExecutors {

    //totally subjective to the task and the system.
    private static final int cores = Runtime.getRuntime().availableProcessors();

    private static ExecutorService singleThread = Executors.newSingleThreadExecutor();
    private static ScheduledExecutorService singleThreadScheduled = Executors.newSingleThreadScheduledExecutor();

    //Creates new threads as needed, reuse previously created threads when they are available.
    private static ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

    //If number of tasks is greater than our number of threads, tasks will wait available threads.
    private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(cores);
    private static ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(cores);

    private class Example {

        private Callable<String> callable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
            return "i";
        };
        private Runnable runnable = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        };

        private void tests() {

            int delay = 10;
            int initialDelay = 0;

            fixedThreadPool.submit(callable);

            //Executes after the giver delay
            scheduledThreadPool.schedule(callable, delay, TimeUnit.SECONDS);

            //Delay between the end of a thread and start of the next
            scheduledThreadPool.scheduleWithFixedDelay(runnable, initialDelay, delay, TimeUnit.SECONDS);

            //Delay between the start of a thread regardless of the previous task have finished
            scheduledThreadPool.scheduleAtFixedRate(runnable, initialDelay, delay, TimeUnit.SECONDS);

            try {
                Set<Callable<String>> tasks = Collections.singleton(callable);

                //runs synchronously, wait until the results are available to return control to enclosing program
                List<Future<String>> futures = fixedThreadPool.invokeAll(tasks);

                //runs synchronously, return one of the tasks and cancel any unfinished tasks.
                String result = fixedThreadPool.invokeAny(tasks);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }




        }


    }


    public static void main(String[] args) {
        new ThreadExecutors().new Example().tests();
    }


}
