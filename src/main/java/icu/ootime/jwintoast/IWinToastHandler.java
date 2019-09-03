<<<<<<< HEAD:src/main/java/io/github/accia/IWinToastHandler.java
package io.github.accia;

import io.github.accia.presets.WinToastLib;
=======
package icu.ootime.jwintoast;

import icu.ootime.jwintoast.presets.WinToastLib;
>>>>>>> develop:src/main/java/icu/ootime/jwintoast/IWinToastHandler.java
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.*;

@NoOffset
@Properties(inherit = WinToastLib.class)
//@Namespace("WinToastLib")
public class IWinToastHandler extends Pointer {
    static {
        Loader.load();
    }
    public IWinToastHandler(){
        allocate();
    }
    public  native void allocate();
    public   @Virtual(true) @Const({false,false,true}) native void toastActivated();
    public   @Virtual(true) @Const({false,false,true}) native void toastActivated(int actionIndex);
    public  @Virtual(true) @Const({false,false,true}) native void toastDismissed(@Cast("IWinToastHandler::WinToastDismissalReason") int state);
    public  @Virtual(true)  @Const({false,false,true}) native void toastFailed();

}
