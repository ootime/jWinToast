import icu.ootime.jwintoast.AbstractJWinToastTemplate;
import icu.ootime.jwintoast.BaseTemplate;
import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.JWinToast;
import icu.ootime.jwintoast.handler.JWinToastHandler;
import icu.ootime.jwintoast.handler.WinToastHandler;
import icu.ootime.jwintoast.xml.XmlJWinToastTemplate;
import icu.ootime.jwintoast.xml.XmlToast;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class xmlToastTest {


    @Test
    public  void main() throws Exception {
//        toastTest g=new toastTest();
//        g.main();
        HMap hMap=new HMap();
        hMap.put("ddww","1/30");
        JWinToast jWinToast= XmlToast.Load((XmlJWinToastTemplate) new XmlJWinToastTemplate()
                .data(hMap)
                .handler(new WinToastHandler<Integer>() {
                    @Override
                    public void handle(String event, Integer integer) {
                        System.out.println(event+"--"+integer);
                    }
                })
                .LoadXml("<toast><visual><binding template=\"ToastGeneric\"><text>Downloadingyourweeklyplaylist...</text><progress title=\"Weeklyplaylist\" value=\"{aavalue}\" valueStringOverride=\"{ddww}\" status=\"Downloading...\"/></binding></visual></toast>")
                .expiration(TimeUnit.SECONDS,100)
        )
                .bulid()
                .init("com.ceshi.de.ass","测试啊啊啊")
                .tag("bb");
        jWinToast.show();
        System.out.println(1/10);
        Thread.sleep(2000);
        new Thread(()->{
            for(int i=1;i<=10;i++){
                HMap up=new HMap();
                double gg=(double) i/10;
                System.out.println(gg);
                up.put("aavalue",String.valueOf(gg));
                System.out.println(jWinToast.update(up));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        TimeUnit.SECONDS.sleep(30);
        System.out.println("end");
        jWinToast.clear();
        //Thread.sleep(60000);
    }
//    @Test
    public void testf(){
        double i=(double) 1/10;
        System.out.println(i);
    }
}
