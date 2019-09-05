package icu.ootime.jwintoast;

import icu.ootime.jwintoast.javacpp.IWinToastHandler;
import icu.ootime.jwintoast.javacpp.WinToastTemplate;

public class WinToast implements Toast {
    private icu.ootime.jwintoast.javacpp.WinToast jWinToast;
    private WinToastTemplate jWinToastTemplate;
    public WinToast(icu.ootime.jwintoast.javacpp.WinToast toast,WinToastTemplate template){
        jWinToast=toast;
        this.jWinToastTemplate=template;
    }
    @Override
    public boolean show() {
//        this.jWinToast.showToast();
        return false;
    }

    @Override
    public boolean hide() {
        return false;
    }

    @Override
    public boolean update() {
        return false;
    }
}
