package icu.ootime.jwintoast.handler;

import icu.ootime.jwintoast.ToastHandler;
public class JWinToastHandler extends ToastHandler {

    private WinToastHandler winToastHandler;

    public JWinToastHandler(WinToastHandler handler){
        this.winToastHandler=handler;
    }

    @Override
    public void handle(String event, Object object) {
        winToastHandler.handle(event,object);
    }
}
