<<<<<<< HEAD:src/main/java/io/github/accia/HString.java
package io.github.accia;
=======
package icu.ootime.jwintoast;
>>>>>>> develop:src/main/java/icu/ootime/jwintoast/HString.java


import icu.ootime.jwintoast.presets.WinToastLib;
import org.bytedeco.javacpp.CharPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.annotation.StdWString;

<<<<<<< HEAD:src/main/java/io/github/accia/HString.java
@Properties(inherit = io.github.accia.presets.WinToastLib.class)
=======
@Properties(inherit = WinToastLib.class)
>>>>>>> develop:src/main/java/icu/ootime/jwintoast/HString.java
@Name("winrt::hstring")
public class HString extends Pointer {
    static {
        Loader.load();
    }
    public HString(){
        allocate();
    }
    public HString(@StdWString CharPointer charPointer){
        allocate(charPointer);
    }
    public  native void allocate();
    public  native void allocate(@StdWString CharPointer charPointer);



}
