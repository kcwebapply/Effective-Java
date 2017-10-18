package effective.program.chapter2.SubClasses;

import java.util.Date;

/**
 * Created by keiwada on 2017/09/23.
 */
public class BadHuman {

    private Date date;

    public BadHuman(Date date){
        this.date =  date;
    }

    public boolean isBirthDay(){
        Date now = new Date();
        if(date.getDate() == now.getDate()){
            return true;
        }
        return false;
    }



}





