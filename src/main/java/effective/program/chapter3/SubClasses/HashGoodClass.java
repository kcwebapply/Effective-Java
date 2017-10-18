package effective.program.chapter3.SubClasses;

import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * equalメソッドをoverrideしたとあるクラス。
 * hashCodeメソッドを同じにしているが、全てのオブジェクトで同じhashCodeを返してしまう。
 */
@AllArgsConstructor
public class HashGoodClass {
    //適当なID
    private String  id;

    @Override
    public boolean equals(Object e){
        HashGoodClass g = (HashGoodClass)e;

        if(this == e)
            return true;
        if(!(e instanceof HashGoodClass))
            return false;
        return isIdSame((HashGoodClass)e);

    }

    private boolean isIdSame(HashGoodClass hashClass) {
        //対称性は確保される
        return this.id.equals(hashClass.id)
                && hashClass.id.equals(this.id);
    }

    @Override
    public int hashCode(){
        System.out.println("hashMapのid。"+this.id);
        return Objects.hashCode(this.id);
    }
}
