package util;

import static thread.start.MyLogger.log;

// 체크 예외를 런타임 예외로 변경하는 간단한 유틸리티를 만들어 사용하자.
public class ThreadUtils {

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log("인터럽트 발생, " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
