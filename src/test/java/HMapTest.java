import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.javacpp.HString;
import icu.ootime.jwintoast.javacpp.HStringMap;
import org.bytedeco.javacpp.CharPointer;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

public class HMapTest {

    @Test
    public void mapPut_Get(){
        HMap hmp=new HMap();
        hmp.put("ceshi","Hellworld1");
        hmp.put("ceshi2","Hellworld2");
        hmp.put("ceshi3","Hellworld3");
        System.out.println(hmp.remove("ceshi")+"---remove");
//        System.out.println(hmp.containsKey("ceshi"));
        System.out.println(hmp.get("ceshi1"));
        System.out.println(Arrays.toString(hmp.values().toArray()));
        System.out.println(hmp.size());
    }
}
