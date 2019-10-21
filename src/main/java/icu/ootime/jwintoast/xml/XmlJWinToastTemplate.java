package icu.ootime.jwintoast.xml;


import icu.ootime.jwintoast.AbstractJWinToastTemplate;
import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.handler.JWinToastHandler;
import icu.ootime.jwintoast.handler.WinToastHandler;
import org.bytedeco.javacpp.CharPointer;

import java.util.concurrent.TimeUnit;

public class XmlJWinToastTemplate extends AbstractJWinToastTemplate implements XmlTemplate<XmlJWinToastTemplate> {
    @Override
    public XmlJWinToastTemplate LoadXml(String str) {
        this.getTemplate().LoadStringToXml(new CharPointer(str));
        return this;
    }

    @Override
    public XmlJWinToastTemplate data(HMap hMap) {
        this.getTemplate().setInitNotificationData(hMap.gethStringMap());
        return this;
    }

    @Override
    public XmlJWinToastTemplate handler(WinToastHandler handler){
        this.setToastHandler(handler);
        return this;
    }


    @Override
    public AbstractJWinToastTemplate duration(int type) {
        return super.duration(type);
    }

    @Override
    public AbstractJWinToastTemplate expiration(TimeUnit unit, long time) {
        return super.expiration(unit, time);
    }

    @Override
    @Deprecated
    public AbstractJWinToastTemplate firstLine(String text) {
        return null;
    }

    @Override
    @Deprecated
    public AbstractJWinToastTemplate textField(String text, int lineCount) {
        return null;
    }

    @Override
    @Deprecated
    public AbstractJWinToastTemplate addAction(String text) {
        return null;
    }
}
