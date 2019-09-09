package icu.ootime.jwintoast.xml;

import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.handler.JWinToastHandler;

public interface XmlTemplate<E> {

    E LoadXml(String str);

    E data(HMap hMap);

    E handler(JWinToastHandler handler);

}
