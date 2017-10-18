package effective.program.chapter3.SubClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by keiwada on 2017/10/01.
 */
@AllArgsConstructor
@NoArgsConstructor
public class EqualPerson implements Cloneable{

    public String name;

    /**
     * 対称性 (this.equals(partner) ならば (partner.equals(this.name))は満たしている
     * 反射生 (this.equals(this)) が true を満たしている。
     * 推移的 (this.equals(partner) かつ partner.equals(partner2)ならば this.equals(partner2))
     * 整合的 (this.equals(partner)) は　何度呼び出しても同じくequal
     * であることを満たす(呼び出し側のコードで確認済み)
     */
    @Override
    public boolean equals(Object o){
        if(!(o instanceof EqualPerson)){
            return false;
        }
        EqualPerson partner = (EqualPerson)o;
        return nameIsSame(partner.name);
    }



    private boolean nameIsSame(String name){
        if(this.name.equals(name)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public EqualPerson clone(){

        EqualPerson clone = new EqualPerson();
        try {
            clone = (EqualPerson)super.clone();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clone;
    }
}
