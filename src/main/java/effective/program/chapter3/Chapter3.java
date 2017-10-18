package effective.program.chapter3;

import effective.program.ChapterInterface;
import effective.program.chapter3.SubClasses.EqualPerson;
import effective.program.chapter3.SubClasses.HashBadClass;
import effective.program.chapter3.SubClasses.HashGoodClass;

import java.util.HashMap;

/**
 * Created by keiwada on 2017/09/22.
 */

public class Chapter3 implements ChapterInterface{

    @Override
    public void callProgram(int koumokuNum) {
        switch (koumokuNum){
            case 0:
                break;
            case 8:
                koumoku8();
                break;
            case 9:
                koumoku9();
                break;
            case 10:
                koumoku10();
                break;
            default:
                System.out.println("項目番号"+koumokuNum+"のプログラム実装はChapter3に存在しません。");
                break;

        }
    }

    /**
     * equalsメソッドの実装に関する一般規約について。
     * 全てのObjectを継承するクラス(全クラス)は、equals,hashCode,toString,clone,finalizeを所持している。
     * それらをoverrideするときの規約についての記述。まずequalについては、対称性、反射生、推移生、整合生の４つが担保されていなければならない。
     * 書籍の例は２つのプロパティを用いてでequal比較をしているが、本プログラムでは1パラメータのみの比較。
     */
    private void koumoku8(){
        EqualPerson me = new EqualPerson("kc");
        EqualPerson kc = new EqualPerson("kc");
        EqualPerson wada = new EqualPerson("kc");
        EqualPerson me2 = me.clone();
        //テストはこんな感じ
        //対称性の確認
        if(me.equals(kc) && kc.equals(me)){
            System.out.println("対称性は担保されています");
        }
        //反射生の確認
        if(me.equals(me)){
            System.out.println("反射生は担保されています");
        }
        //推移性
        if(me.equals(kc) && kc.equals(wada) && me.equals(wada)){
            System.out.println("推移生は担保されています。");
        }
        //整合性
        if(me.equals(me2)){
            //何度も me の equalsは読んでいるので、
            System.out.println("整合生は担保されています。");
        }
    }

    /**
     * equalsメソッドをoverrideするときはhashCodeもoverrideし、変更を加える。
     * 何故なら、JavaのObjectは、等しいオブジェクトは同じハッシュコードを持たなくてはいけず、その前提で作られているからである。
     * equalは一致するが、hashCodeは異なる、ということはあってはならない。
     * IntegerやStringのhashCode実装を見てみるといい。
     */
    private void koumoku9(){
        HashMap<HashBadClass,String> badMap = new HashMap<>();
        HashBadClass bad = new HashBadClass("1");
        badMap.put(bad,"1");
        System.out.println();
        String id = badMap.get(new HashBadClass("1")); //HashMapのインデクス(key)に登録されているHashCodeが異なるので、equalとしては同じでも検索に引っかからない。
        System.out.println("検索結果は"+id+"です。この場合はhashCode"+bad.hashCode()+"からに正しく登録できません。");

        HashMap<HashGoodClass,String> goodMap = new HashMap<>();
        HashGoodClass good = new HashGoodClass("1");
        goodMap.put(good,"1");
        HashGoodClass good2 =  new HashGoodClass("1");
        String id2 = goodMap.get(good2);
        System.out.println("検索結果は"+id2+"です。この場合はhashCode"+good.hashCode()+"から正しく値を取得できています。");
    }

    /**
     * toStringメソッドをoverrideする....
     * 基本のtoStringメソッドは、クラス名@アドレス　の形を返すが、overrideして読みやすいものにするのが推奨されている。
     * toStringメソッドには、オブジェクトの知りたい内容を返すようにすべきである。
     */
    private void koumoku10(){
        String hashMapString = new HashMap<>().toString();
        StringBuffer strBufString = new StringBuffer("test");
        System.out.println("HashMapクラスのtoString()は"+hashMapString+" StringBufferクラスのtoString()は"+strBufString.toString());
    }

}
