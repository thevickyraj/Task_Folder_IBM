

public class Demo06_PerformanceService {

    // Completes in about 100 ms
    public void quickOperation() throws InterruptedException {
        Thread.sleep(100);
    }

    // Completes in about 1000 ms
    public void slowOperation() throws InterruptedException {
        Thread.sleep(1000);
    }
}