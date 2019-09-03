
import icu.ootime.jwintoast.*;
import org.bytedeco.javacpp.CharPointer;
import org.bytedeco.javacpp.IntPointer;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class test {
    public static void main(String[] args)  {
//        WinToastLib iWinToastHandler=new WinToastLib();
////        iWinToastHandler.toastActivated(1);
//        WinToastLib.IWinToastHandler dd=new WinToastLib.IWinToastHandler();
////        iWinToastHandler(dd);
//        dd.toastActivated(1);
        try {
            WinToastTemplate winToastTemplate=new WinToastTemplate(WinToastTemplate.WinToastTemplateType.TOASTIMAGEANDTEXT02);
//            winToastTemplate.setFirstLine(new CharPointer("d"));
            System.out.println(winToastTemplate.address());
            WinToast winToast=WinToast.instance();
            IWinToastHandler iWinToastHandler=new IWinToastHandler(){
                @Override
                public void toastActivated() {
                    System.out.println("toastActivated");
                }

                @Override
                public void toastActivated(int actionIndex) {
                    System.out.println("toastActivated-----"+actionIndex);
                }

                @Override
                public void toastDismissed(int state) {
                    System.out.println("toastDismissed-----"+state);
                }

                @Override
                public void toastFailed() {
                    System.out.println("toastFailed");
                }
            };
            winToast.setAppName(new CharPointer("测试"));
            CharPointer aumi= winToast.configureAUMI(new CharPointer("DDD"),new CharPointer("ProductName"),new CharPointer("SubProduct"),new CharPointer("VersionInformation"));
//        System.out.println(aumi.getString());
            winToast.setAppUserModelId(aumi);
            System.out.println(winToast.initialize());

//            winToastTemplate.setTextField(new CharPointer("点对点"),WinToastTemplate.TextField.FirstLine);
//            winToastTemplate.addAction(new CharPointer("我是按钮啊"));
//            winToastTemplate.addAction(new CharPointer("我是按钮啊"));
//            winToastTemplate.setDuration(WinToastTemplate.Duration.Short);
//            winToastTemplate.setTextField(new CharPointer("关于2019年中秋节放假安排的通知根据国务院办公厅通知精神，现将2019年中秋节放假安排通知如下:9月13日（星期五）放假调休，与周末连休。请广大市民提前安排好工作生活，节日期间注意安全，度过一个欢乐、祥和的节日假期。"),WinToastTemplate.TextField.SecondLine);
//            winToastTemplate.setImagePath(new CharPointer("C:\\Users\\TK\\Desktop\\a.jpg"));
            winToastTemplate.setExpiration(10000);
            winToastTemplate.LoadStringToXml(new CharPointer("<toast><visual><binding template=\"ToastGeneric\"><text>Downloadingyourweeklyplaylist...</text><progress title=\"Weeklyplaylist\" value=\"{aavalue}\" valueStringOverride=\"{ddww}\" status=\"Downloading...\"/></binding></visual></toast>"));
            HStringMap hStringMap4=new HStringMap();
            hStringMap4.put(new HString(new CharPointer("ddww")),new HString(new CharPointer("10/90 20")));
            winToastTemplate.setInitNotificationData(hStringMap4);
            //            winToastTemplate.addAction(new CharPointer("是"));
//            winToastTemplate.addAction(new CharPointer("否"));
            IntPointer intPointer=new IntPointer(0);
            winToast.setAppGroup(new CharPointer("ddd"));
            winToast.setAppTag(new CharPointer("aaa"));
            int uid=winToast.showToast(winToastTemplate,iWinToastHandler,intPointer);
            Thread.sleep(1000);
//            coventHString coventHString=new coventHString();

            HStringMap hStringMap=new HStringMap();
            hStringMap.put(new HString(new CharPointer("aavalue")),new HString(new CharPointer("0.1")));
//            hStringMap.put(new HString(new CharPointer("ddww")),new HString(new CharPointer("1ssss")));

            IntPointer intPointer1=new IntPointer(0);
            System.out.println(winToast.update(hStringMap,intPointer1));
            System.out.println(intPointer1.get());
            System.out.println("返回错误:"+ winToast.strerror(intPointer.get()).getString());
            System.out.println(winToast.address());

            Thread.sleep(2000);
           HStringMap hStringMap2=new HStringMap();
            hStringMap2.put(new HString(new CharPointer("aavalue")),new HString(new CharPointer("1")));
            hStringMap2.put(new HString(new CharPointer("ddww")),new HString(new CharPointer("1ssss")));
            System.out.println(winToast.update(hStringMap2,intPointer1));
//            System.out.println(winToast.hideToast(uid));
            Thread.sleep(15000);

            System.out.println("未意外推出");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
