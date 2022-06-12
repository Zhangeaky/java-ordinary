package se.thread;


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


//        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 5, 3000, new LinkedBlockingQueue<Runnable>(5),
//                )
    }


}


