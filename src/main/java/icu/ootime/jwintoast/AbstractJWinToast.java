package icu.ootime.jwintoast;

import icu.ootime.jwintoast.handler.JWinToastHandler;
import icu.ootime.jwintoast.javacpp.HStringMap;
import org.bytedeco.javacpp.CharPointer;
import org.bytedeco.javacpp.IntPointer;

public abstract class AbstractJWinToast implements Toast ,WinToast {

    private Template template;
    private int toastid;
    private icu.ootime.jwintoast.javacpp.WinToast winToast;
    public AbstractJWinToast(Template toastTemplate){
        this.template=toastTemplate;
        winToast=icu.ootime.jwintoast.javacpp.WinToast.instance();
    }

    public AbstractJWinToast(){
    }


    @Override
    public void setAppName(String appName) {
        winToast.setAppName(new CharPointer(appName));
    }

    @Override
    public void setAppTag(String tag) {
        winToast.setAppTag(new CharPointer(tag));
    }

    @Override
    public void setAppGroup(String group) {
        winToast.setAppGroup(new CharPointer(group));
    }

    @Override
    public void setAppUserModelId(String appUserModelId) {
        winToast.setAppUserModelId(new CharPointer(appUserModelId));
    }

    @Override
    public void clear() {
        winToast.clear();
    }

    @Override
    public boolean hideToast(int id) {
        winToast.hideToast(id);
        return false;
    }

    @Override
    public String getError(int code) {
        return winToast.strerror(code).getString();
    }

    @Override
    public boolean show() throws Exception {
        IntPointer errocode = new IntPointer(1);
        toastid=winToast.showToast(template.getTemplate(),new JWinToastHandler(template.getHandler()),errocode);
        if(errocode.get()!=0){
            throw new Exception(this.getError(errocode.get()));
        }
        return true;
    }

    @Override
    public boolean hide() throws Exception {
        return  winToast.hideToast(this.getToastid());
    }

    @Override
    public boolean update(HStringMap hStringMap) throws Exception {
        IntPointer errocode = new IntPointer(0);
        int relaut = winToast.update(hStringMap,errocode);
        if(errocode.get()!=0){
            throw new Exception(this.getError(errocode.get()));
        }
        return relaut==0?true:false;
    }

    @Override
    public void initialize() {
        winToast.initialize();
    }

    public int getToastid() {
        return toastid;
    }
}
