package thread.sync;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class BankAccountV3 implements BankAccount{
    private int balance;

    public BankAccountV3(int initialBalance) {
        this.balance = initialBalance;
    }
    @Override
    // `withdraw()` 메서드 앞에 사용하던 `synchronized` 를 제거한다.
    public boolean withdraw(int amount) {
        log("거래 시작: " + getClass().getSimpleName());
        // `synchronized (this) {}` : 안전한 임계 영역을 코드 블럭으로 지정한다.
        // 이렇게 하면 꼭 필요한 코드만 안전한 임계 영역으로 만들 수 있다.
        // `synchronized (this)` : 여기서 괄호 `()` 안에 들어가는 값은 락을 획득할 인스턴스의 참조이다.
        synchronized (this) {
            log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
                return false;
            }
            log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
            sleep(1000);
            balance = balance - amount;
            log("[출금 완료] 출금액: " + amount + ", 변경 잔액: " + balance);
        }
        log("거래 종료");
        return true;
    }

    @Override
    public synchronized int getBalance() {
        return balance;
    }


}
