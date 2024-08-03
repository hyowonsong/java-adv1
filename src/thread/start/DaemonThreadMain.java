package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(true); // 데몬 스레드 여부 - 기본 값은 false 이다.
        // 데몬 스레드 여부는 start() 실행 전에 결정해야 한다. 이후에는 변경되지 않는다.
        // 데몬 스레드는 모든 user 스레드가 종료되면 자동으로 종료된다.
        // 현재 유일한 user 스레드인 main 스레드가 종료되면서 자바 프로그램도 종료된다.
        // 따라서, run() end가 출력 되기 전에 프로그램이 종료된다.(모든 user 스레드가 종료되면 자동으로 종료되기 때문이다.)
        daemonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() end");
    }

    static class DaemonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run() start");
            try {
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ": run() end");
        }
    }
}
