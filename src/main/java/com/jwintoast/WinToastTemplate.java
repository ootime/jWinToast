package com.jwintoast;

import org.bytedeco.javacpp.CharPointer;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.Pointer;
import org.bytedeco.javacpp.annotation.*;

@Properties(inherit = com.jwintoast.presets.WinToastLib.class)
@Namespace("WinToastLib")
public class WinToastTemplate extends Pointer {
    static { Loader.load(); }

    public WinToastTemplate(){allocate();}

    public WinToastTemplate( @Cast("WinToastTemplate::WinToastTemplateType") int winToastTemplateType){
        allocate(winToastTemplateType);
    }
//    public WinToastTemplate(Pointer p) { super(p); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
//    public WinToastTemplate(long size) { super((Pointer)null); allocateArray(size); }
//    private native void allocateArray(long size);
    public  native void allocate();
    public  native void allocate(@Cast("WinToastTemplate::WinToastTemplateType") int winToastTemplateType);

    public native  void setFirstLine(@Const @StdWString CharPointer text);
    public native void setTextField(@Const @StdWString CharPointer text,@Cast("WinToastTemplate::TextField") int FirstLine);
    public native void addAction(@Const @StdWString CharPointer label);
    public native void setAttributionText(@Const @StdWString CharPointer text);

    public native void setDuration(@Cast("WinToastTemplate::Duration") int duration);

    public native void setImagePath(@Const @StdWString CharPointer imagepath);

    public native  void setExpiration(int millisecondsFromNow);

    public native void LoadStringToXml(@Const @StdWString CharPointer strxml);

    @Override public WinToastTemplate position(long position) {
        return (WinToastTemplate)super.position(position);
    }


    public static class Duration{
        /** enum WinToastLib::WinToastTemplate::Duration */
        public static final int System = 0, Short = 1, Long = 2;
    }

    public static class AudioOption{
        /** enum WinToastLib::WinToastTemplate::AudioOption */
        public static final int Default = 0, Silent = 1, Loop = 2;
    }


    public static class TextField{
        /** enum WinToastLib::WinToastTemplate::TextField */
        public static final int FirstLine = 0, SecondLine = 1, ThirdLine = 2;
    }

    public static class WinToastTemplateType{
        /** enum WinToastLib::WinToastTemplate::WinToastTemplateType */
        public static final int TOASTIMAGEANDTEXT01=0
                , TOASTIMAGEANDTEXT02=1,
                TOASTIMAGEANDTEXT03=2,
                TOASTIMAGEANDTEXT04=3;
        public  static final int TOASTTEXT01=4,
                TOASTTEXT02=5,
                TOASTTEXT03=6,
                TOASTTEXT04=7;
    }
}
