package KoordynacjaWatkow;

public interface IKoordynator{
    void startA() throws InterruptedException;

    void startB() throws InterruptedException;

    void startC() throws InterruptedException;

    void koniecA() throws InterruptedException;

    void koniecB() throws InterruptedException;

    void koniecC() throws InterruptedException;
}
