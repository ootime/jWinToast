package icu.ootime.jwintoast;


public interface WinToast {

    void setAppName(String appName);
    void setAppTag(String tag);
    void setAppGroup(String group);
    void setAppUserModelId(String appUserModelId);
    void clear();
    boolean hideToast(int id);
    void initialize();
    String getError(int code);
}
