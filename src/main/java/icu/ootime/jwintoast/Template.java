package icu.ootime.jwintoast;

import icu.ootime.jwintoast.javacpp.WinToastTemplate;

import java.util.concurrent.TimeUnit;

public interface Template<E> {

   E duration(int n);

   E expiration(TimeUnit unit, long time);

   E firstLine(String text);

   E textField(String text,int lineCount);

   E addAction(String text);

   ToastHandler getHandler();

   WinToastTemplate  getTemplate();

}
