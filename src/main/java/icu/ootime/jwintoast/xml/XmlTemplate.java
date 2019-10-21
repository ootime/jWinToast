package icu.ootime.jwintoast.xml;

import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.handler.JWinToastHandler;
import icu.ootime.jwintoast.handler.WinToastHandler;

public interface XmlTemplate<E> {

    E LoadXml(String str);

    E data(HMap hMap);

    E handler(WinToastHandler<Integer> handler);

}
