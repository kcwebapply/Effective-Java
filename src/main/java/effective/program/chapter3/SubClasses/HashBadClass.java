package effective.program.chapter3.SubClasses;

import lombok.AllArgsConstructor;

/**
 * equalメソッドをoverrideしたとあるクラス。
 * Hashcodeをoverrideしていないため、hashmap登録時に問題が出る。
 */
@AllArgsConstructor
public class HashBadClass {
    //適当なID
    private String id;

    @Override
    public boolean equals(Object e){
        //整合性を確保
        if(!e.equals(e))
            return true;
        //反射性を確保
        if(this.equals(e))
            return true;

        if((e instanceof HashBadClass))
            return false;
        return isIdSame((HashBadClass)e);

    }

    private boolean isIdSame(HashBadClass hashClass) {
        //対称性は確保される
        return this.id.equals(hashClass.id)
                && hashClass.id.equals(this.id);
    }
}
