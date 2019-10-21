package icu.ootime.jwintoast.handler;

public interface WinToastHandler<T> {
    void handle(String event,T t);
}
