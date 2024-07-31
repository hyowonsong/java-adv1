package thread.control;

public class CheckedExceptionMain {

    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable{
        // 부모 메서드인 Runnable 인터페이스의 run() 메서드는 아무런 체크 예외를 던지지 않는다.
        // 따라서 ,Runnable 인터페이스의 run() 메서드를 재정의 하는 곳에서는 체크 예외를 밖으로 던질 수 없다.

        @Override
        public void run() /*throws Exception*/ { // 주석 풀면 예외 발생
            // throw new Exception();  주석 풀면 예외 발생
        }
    }
}
