package icu.ootime.jwintoast.xml;

import icu.ootime.jwintoast.HMap;
import icu.ootime.jwintoast.JWinToast;
import icu.ootime.jwintoast.Template;

public class XmlToast {
    private XmlJWinToastTemplate xmlTemplate;

    private XmlToast(XmlJWinToastTemplate xmlTemplate){
        this.xmlTemplate=xmlTemplate;
    }
    public static XmlToast Load(XmlJWinToastTemplate toastTemplate){
        XmlToast xmlToastBuilder=new XmlToast(toastTemplate);
        return xmlToastBuilder;
    }
    public static XmlToast Load(){

        return XmlToast.Load(new XmlJWinToastTemplate());
    }

    public XmlJWinToastWapper bulid(){
        XmlJWinToastWapper jWinToast=new XmlJWinToastWapper(this.xmlTemplate);
        return jWinToast;
    }
   public class XmlJWinToastWapper extends JWinToast{
        public XmlJWinToastWapper(Template jWinToastTemplate){
            super(jWinToastTemplate);
        }
        public XmlJWinToastWapper init(String modelId,String appname){
            this.setAppUserModelId(modelId);
            this.setAppName(appname);
            this.initialize();
            return this;
        }

        public XmlJWinToastWapper group(String group){
            this.setAppGroup(group);
            return this;
        }
        public XmlJWinToastWapper tag(String tag){
            this.setAppTag(tag);
            return this;
        }

        public XmlJWinToastWapper data(HMap hMap){
            return this;
        }
    }
}
