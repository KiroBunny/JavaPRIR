package SemaphoreProducentConsument.wieleu_producentow;

public interface Magazyn<T> {


    void add(T product) throws InterruptedException;

    T get() throws InterruptedException;
}
