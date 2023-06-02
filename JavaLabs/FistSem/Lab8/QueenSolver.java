package JavaLabs.FistSem.Lab8;

import java.util.concurrent.atomic.AtomicInteger;

public class QueenSolver implements Runnable {
    private int n;
    private int startCol;
    private int endCol;
    private AtomicInteger count;
    private boolean[] cols;
    private boolean[] upDiag;
    private boolean[] downDiag;

    public QueenSolver(int n, int startCol, int endCol, AtomicInteger count, boolean[] cols, boolean[] upDiag, boolean[] downDiag) {
        this.n = n;
        this.startCol = startCol;
        this.endCol = endCol;
        this.count = count;
        this.cols = cols;
        this.upDiag = upDiag;
        this.downDiag = downDiag;
    }

    public void run() {
        solve(0);
    }

    private void solve(int row) {
        if (row == n) {
            count.incrementAndGet();
        } else {
            for (int col = startCol; col < endCol; col++) {
                if (!cols[col] && !upDiag[row + col] && !downDiag[row - col + n - 1]) {
                    cols[col] = true;
                    upDiag[row + col] = true;
                    downDiag[row - col + n - 1] = true;
                    solve(row + 1);
                    cols[col] = false;
                    upDiag[row + col] = false;
                    downDiag[row - col + n - 1] = false;
                }
            }
        }
    }

    public static int calcQueenNum(int n, int threadNum) throws InterruptedException {
        if (threadNum < 1) {
            throw new IllegalArgumentException("Thread number must be at least 1");
        }
        AtomicInteger count = new AtomicInteger(0);
        boolean[] cols = new boolean[n];
        boolean[] upDiag = new boolean[2 * n - 1];
        boolean[] downDiag = new boolean[2 * n - 1];
        Thread[] threads = new Thread[threadNum];
        int step = (int) Math.ceil((double) n / threadNum);
        for (int i = 0; i < threadNum; i++) {
            int startCol = i * step;
            int endCol = Math.min(startCol + step, n);
            threads[i] = new Thread(new QueenSolver(n, startCol, endCol, count, cols, upDiag, downDiag));
            threads[i].start();
        }
        for (int i = 0; i < threadNum; i++) {
            threads[i].join();
        }
        return count.get();
    }
}