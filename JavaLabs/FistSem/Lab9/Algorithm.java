package JavaLabs.FistSem.Lab9;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Algorithm {

    private ArrayList<Integer> primeNumbs;
    private ExecutorService executor;

    public Algorithm() {
        this(Runtime.getRuntime().availableProcessors());
    }

    public Algorithm(int threads) {
        primeNumbs = new ArrayList<>(List.of(2, 3, 5, 7));
        executor = Executors.newFixedThreadPool(threads);
    }

    public void findPrimeNumbs(TaskQueue queue) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(queue.tasksCount());

        for (;;) {
            TaskQueue.MyTask curTask = queue.pop();
            if (curTask == null || curTask.isComplete()) break;

            executor.submit(new PrimeFinder(curTask, (task) -> {
                queue.push(task);
                latch.countDown();
            }));
        }

        latch.await();
        executor.shutdown();
    }

    class PrimeFinder implements Runnable {
        private TaskQueue.MyTask task;
        private TaskEnd endRun;

        public PrimeFinder(TaskQueue.MyTask task, TaskEnd endRun) {
            this.task = task;
            this.endRun = endRun;
        }

        @Override
        public void run() {
            for (int i = task.getStart(); i < task.getEnd(); i++) {
                if (isPrime(i)) {
                    task.addPrime(i);
                }
            }

            endRun.onEnding(task);
        }

        public boolean isPrime(Integer num) {
            int end = (int) Math.sqrt(num) + 1;
            int i;

            //System.out.println(num.toString() + " Checking cache....");

            for (i = 0; i < primeNumbs.size(); i++) {
                if (primeNumbs.get(i) >= end) {
                    return true;
                }
                if (num % primeNumbs.get(i) == 0) {
                    return false;
                }
            }

            synchronized (primeNumbs) {
                for (int j = i; j < primeNumbs.size(); j++) {
                    if (primeNumbs.get(j) >= end) {
                        return true;
                    }
                    if (num % primeNumbs.get(j) == 0) {
                        return false;
                    }
                }

                for (int j = primeNumbs.get(i - 1) + 2; j < end; j+=2) {
                    if (isPrime(j)) {
                        if (primeNumbs.get(primeNumbs.size() - 1) != j) {
                            primeNumbs.add(j);
                        }
                        if (num % j == 0) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }

        interface TaskEnd {
            void onEnding(TaskQueue.MyTask task);
        }

    }

}
