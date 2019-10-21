package icu.ootime.jwintoast;


import icu.ootime.jwintoast.javacpp.IWinToastHandler;

public abstract class ToastHandler extends IWinToastHandler {
//    toastFailed
//            toastActivated
//    toastDismissed

    @Override
    public void toastActivated() {
        handle("Activated",null);
    }

    @Override
    public void toastActivated(int actionIndex) {
        handle("Activated",actionIndex);
    }

    @Override
    public void toastDismissed(int state) {
        handle("Dismissed",state);
    }

    @Override
    public void toastFailed() {
        handle("Failed",null);
    }

    public abstract void handle(String event,Object object);
}
