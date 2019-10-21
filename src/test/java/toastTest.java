import icu.ootime.jwintoast.BaseTemplate;
import icu.ootime.jwintoast.JWinToast;
import icu.ootime.jwintoast.handler.JWinToastHandler;
import icu.ootime.jwintoast.handler.WinToastHandler;
import icu.ootime.jwintoast.javacpp.WinToastTemplate;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class toastTest {
    @Test
    public   void  main() throws Exception {
        BaseTemplate abstractJWinToastTemplate=new BaseTemplate(WinToastTemplate.WinToastTemplateType.TOASTIMAGEANDTEXT03);
        abstractJWinToastTemplate.addAction("时间耽误你");
        abstractJWinToastTemplate.firstLine("哈哈哈哈");
        abstractJWinToastTemplate.textField("都往往会变得",1);
        abstractJWinToastTemplate.expiration(TimeUnit.SECONDS,3);
//        abstractJWinToastTemplate.duration(WinToastTemplate.Duration.Short);
        abstractJWinToastTemplate.setToastHandler(new WinToastHandler<Integer>() {
            @Override
            public void handle(String event, Integer integer) {
                System.out.println(event+"-"+integer);
            }
        });
        JWinToast jWinToast1=new JWinToast(abstractJWinToastTemplate);

        jWinToast1.setAppName("测试aa");
        jWinToast1.setAppUserModelId("com.ceshi.de.aaa");
        jWinToast1.initialize();
        try {
            jWinToast1.show();
            TimeUnit.SECONDS.sleep(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        TimeUnit.SECONDS.sleep(6);
        System.out.println("-----------");
        jWinToast1.clear();
//        jWinToast1.show();
//        TimeUnit.SECONDS.sleep(6);
    }
}
