package SemaphoreProducentConsument.jeden_producent;

public interface Magazyn<T> {

    void add(T product) throws InterruptedException;


    T get() throws InterruptedException;
}
