import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.JWinToast;
import icu.ootime.jwintoast.handler.JWinToastHandler;
import icu.ootime.jwintoast.xml.XmlJWinToastTemplate;
import icu.ootime.jwintoast.xml.XmlToast;
import org.junit.Test;

public class xmlToastTest {


    @Test
    public void xmltoast() throws Exception {
        HMap hMap=new HMap();
        hMap.put("ddww","1/30");
        JWinToast jWinToast= XmlToast.Load(new XmlJWinToastTemplate()
                .data(hMap)
                .handler(new JWinToastHandler())
                .LoadXml("<toast><visual><binding template=\"ToastGeneric\"><text>Downloadingyourweeklyplaylist...</text><progress title=\"Weeklyplaylist\" value=\"{aavalue}\" valueStringOverride=\"{ddww}\" status=\"Downloading...\"/></binding></visual></toast>"))
                .bulid()
                .init("com.ceshi.de.ass","测试啊啊啊")
                .tag("bb");
        jWinToast.show();
        Thread.sleep(2000);
        HMap up=new HMap();
        up.put("aavalue","1");
        System.out.println(jWinToast.update(up));
        Thread.sleep(20000);
    }
}
