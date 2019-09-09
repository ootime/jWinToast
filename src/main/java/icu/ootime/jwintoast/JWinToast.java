package icu.ootime.jwintoast;

public class JWinToast extends  AbstractJWinToast {

    public  JWinToast (){

    }

    public  JWinToast(Template jWinToastTemplate){
        super(jWinToastTemplate);
    }

    public boolean update(HMap hMap){
        try {
            return this.update(hMap.gethStringMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  false;
    }

}
