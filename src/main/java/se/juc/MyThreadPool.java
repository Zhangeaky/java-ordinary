package se.juc;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 *  学习线程池相关的概念:
 *
 *
 *
 *
 *
 *
 *
 *
 */
public class MyThreadPool {

    class WorkerThread extends Thread {

        public void run() {
            while (true) {
                try {
                    System.out.format("[%s] 开始拿取任务 ...\n", Thread.currentThread().getName());
                    Runnable task = workQueue.take();
                    task.run();
                    System.out.format("[%s] 任务结束 ...\n", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    BlockingQueue<Runnable> workQueue;

    List<WorkerThread> threads = new ArrayList<>();

    public MyThreadPool(int poolSize,  BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;

        for (int i=0; i<poolSize; i++) {

            WorkerThread wt = new WorkerThread();
            //这里是为什么? 线程尚未接收任务直接start, 会在workQueue拿去任务的时候阻塞住
            wt.start();
            threads.add(wt);
        }
    }

    /**
     *
     * 将任务提交到队列中
     *
     * @param command
     */
    void execute(Runnable command) {
        try {
            workQueue.put(command);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(2);

        MyThreadPool pool = new MyThreadPool(10, workQueue);

        pool.execute(()-> System.out.println("hello"));

    }
}

class JDKThreadPoolDemo {

    public static void main(String[] args) {

        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);

        while (true) {
            pool.execute(()-> System.out.println(Thread.currentThread().getName()));
        }






        //ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 5)


    }

}


/**
 *
 * @see FutureTask
 * @see Future
 * @see Callable
 *  cancel()
 *  isCancelled()
 *  get() 会阻塞住 如果线程没有执行完成就会阻塞
 *  get(long timeout) 支持超时
 *
 *
 * Executor submit方法
 *
 *    Future<> submit(Runnable task)
 *      通过返回值get进行结果的拿取
 *
 *    <T> Future<T> submit(Callable<T> task)
 *
 *    Future<T> submit(Runnable task, T result)
 *
 */
class DoTask{

    static class T2Task implements Callable<String>{

        @Override
        public String call() throws Exception {

            System.out.println("T2: 洗茶壶 ...");
            TimeUnit.SECONDS.sleep(1L);

            System.out.println("T2: 洗茶杯 ...");
            TimeUnit.SECONDS.sleep(2L);

            System.out.println("T2 取茶叶...");
            TimeUnit.SECONDS.sleep(1L);

            return "龙井";
        }
    }

    static class T1Task implements Callable<String>{

        private FutureTask<String> ft2;

        public T1Task(FutureTask<String> ft2) {
            this.ft2 = ft2;
        }

        @Override
        public String call() throws Exception {
            System.out.println("T1 洗水壶 ...");
            TimeUnit.SECONDS.sleep(1L);

            System.out.println("T1: 烧开水 ...");
            TimeUnit.SECONDS.sleep(15L);


            String s = ft2.get();
            System.out.println("T1 已经拿到茶叶了 ..."+s) ;

            System.out.println("T1: 泡茶 ...");

            return "上茶" + s;
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> t2 = new FutureTask<>(new T2Task());

        FutureTask<String> t1 = new FutureTask<>(new T1Task(t2));

        new Thread(t1).start();

        new Thread(t2).start();

        System.out.println(t1.get());

    }




}


