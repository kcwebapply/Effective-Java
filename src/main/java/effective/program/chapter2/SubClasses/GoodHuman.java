package effective.program.chapter2.SubClasses;

import java.util.Date;

/**
 * Created by keiwada on 2017/09/23.
 */
public class GoodHuman {

    private Date date;

    private static Date now;

    //static初期化で、クラス情報がスタックに読まれた時に一度だけ実行される。
    static{
        now = new Date();
    }

    public GoodHuman(Date date){
        this.date =  date;
    }

    public boolean isBirthDay(){

        if(this.date.getDate() == this.now.getDate()){
            return true;
        }
        return false;
    }

}