package icu.ootime.jwintoast.javacpp;


import icu.ootime.jwintoast.javacpp.presets.WinToastLib;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.Cast;
import org.bytedeco.javacpp.annotation.Name;
import org.bytedeco.javacpp.annotation.Properties;
import org.bytedeco.javacpp.annotation.StdWString;

@Properties(inherit = WinToastLib.class)
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
    public HString(String string){
        this(new CharPointer(string));
    }
    public  native void allocate();
    public  native void allocate(@StdWString CharPointer charPointer);

    public native @Cast("wchar_t *")
    CharPointer  c_str();

    @Override
    public String toString() {
        return this.c_str().getString();
    }
}
