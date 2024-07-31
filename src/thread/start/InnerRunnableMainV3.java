package thread.start;

import static thread.start.MyLogger.log;

// 익명 클래스를 사용하여 Runnable 만들기
public class InnerRunnableMainV3 {

    public static void main(String[] args) {
        log("main() start");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        });

        thread.start();
        log("main() end");
    }
}