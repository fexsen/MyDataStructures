package JavaLabs.FistSem.Lab9;

public class Main {
    public static void main(String[] args) {
        TaskQueue queue = new TaskQueue();

        queue.push(new TaskQueue.MyTask(100, 1000));
        queue.push(new TaskQueue.MyTask(1001, 2000));
        queue.push(new TaskQueue.MyTask(2001, 3000));
        queue.push(new TaskQueue.MyTask(3001, 4000));

        Algorithm executor = new Algorithm();
        try {
            executor.findPrimeNumbs(queue);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace(System.out);
        }

        queue.showResult();

    }
}