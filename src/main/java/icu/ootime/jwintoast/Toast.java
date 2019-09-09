package icu.ootime.jwintoast;

import icu.ootime.jwintoast.javacpp.HStringMap;

public interface Toast {
    boolean show() throws Exception;
    boolean hide() throws Exception;
    boolean update(HStringMap hStringMap) throws Exception;
}
