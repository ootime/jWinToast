package icu.ootime.jwintoast;

import icu.ootime.jwintoast.javacpp.WinToastTemplate;
import org.bytedeco.javacpp.CharPointer;

import java.util.concurrent.TimeUnit;

public abstract class AbstractJWinToastTemplate implements Template<AbstractJWinToastTemplate>{

    private WinToastTemplate toastTemplate;

    private ToastHandler toastHandler;

    public AbstractJWinToastTemplate(){
        this.toastTemplate=new WinToastTemplate();
    }
    public AbstractJWinToastTemplate(int templateid){
        this.toastTemplate=new WinToastTemplate(templateid);
    }

    @Override
    public AbstractJWinToastTemplate duration(int type){
        toastTemplate.setDuration(type);
        return this;
    }

    @Override
    public AbstractJWinToastTemplate expiration(TimeUnit unit, long time){
        toastTemplate.setExpiration((int)unit.toMillis(time));
        return this;
    }

    @Override
    public AbstractJWinToastTemplate firstLine(String text){
        toastTemplate.setFirstLine(new CharPointer(text));
        return this;
    }

    @Override
    public AbstractJWinToastTemplate textField(String text, int lineCount){
        toastTemplate.setTextField(new CharPointer(text),lineCount);
        return this;
    }

    @Override
    public AbstractJWinToastTemplate addAction(String text) {
        toastTemplate.addAction(new CharPointer(text));
        return this;
    }

    @Override
    public ToastHandler getHandler() {
        return this.toastHandler;
    }

    @Override
    public WinToastTemplate getTemplate() {
        return this.toastTemplate;
    }

    public void setToastHandler(ToastHandler toastHandler) {
        this.toastHandler = toastHandler;
    }
}
