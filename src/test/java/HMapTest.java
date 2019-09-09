import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.JWinToast;
import icu.ootime.jwintoast.handler.JWinToastHandler;
import icu.ootime.jwintoast.xml.XmlJWinToastTemplate;
import icu.ootime.jwintoast.xml.XmlToast;
import org.junit.Test;

import java.util.Arrays;

public class HMapTest {

    @Test
    public void mapPut_Get() throws Exception {
        HMap hmp=new HMap();
        hmp.put("ceshi","Hellworld1");
        hmp.put("ceshi2","Hellworld2");
        hmp.put("ceshi3","Hellworld3");
        System.out.println(hmp.remove("ceshi")+"---remove");
//        System.out.println(hmp.containsKey("ceshi"));
        System.out.println(hmp.get("ceshi1"));
        System.out.println(Arrays.toString(hmp.values().toArray()));
        System.out.println(hmp.size());
//        new JWinToastTemplate().l().duration(1);
    }
}
