package thread.control;


import static util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable(), "myThread");
        log("myThread.state1 = " + thread.getState()); // NEW
        log("myThread.start()");
        // thread.start() 실행하면서 아래의 Runnable 상태가 된다.
        thread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + thread.getState()); // TIMED_WAITING
        Thread.sleep(4000);
        log("myThread.state5 = " + thread.getState()); // TERMINATED
        log("end");
    }

    static class MyRunnable implements Runnable {
        public void run() {
            try {
                log("start");
                //  Thread.currentThread().getState())를 호출하여 해당 코드를 실행하는 스레드 객체를 조회
                log("myThread.state2 = " + Thread.currentThread().getState()); // RUNNABLE
                log("sleep() start");
                // Thread.sleep 을 호출한 스레드는 TIMED_WAITING 상태가 되면서 특정 시간 만큼 대기한다.
                Thread.sleep(3000);
                log("sleep() end");
                log("myThread.state4 = " + Thread.currentThread().getState()); // RUNNABLE
                log("end");
                // Thread.sleep()은 InterruptedException 이라는 체크 예외를 던진다.
                // 따라서, 체크 예외를 잡아서 처리하거나 던져야 한다.
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}