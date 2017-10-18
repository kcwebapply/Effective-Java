package effective.program.chapter2;

import effective.program.ChapterInterface;
import effective.program.chapter2.SubClasses.*;


import java.util.Date;

/**
 * Created by keiwada on 2017/09/22.
 */
public class Chapter2 implements ChapterInterface {


    @Override
    public void callProgram(int koumokuNum) {
        switch (koumokuNum){
            case 0:
                break;
            case 1:
                koumoku1();
                break;
            case 2:
                koumoku2();
                break;
            case 5:
                koumoku5();;
                break;
            case 6:
                koumoku6();
                break;
            default:
                System.out.println("項目番号"+koumokuNum+"のプログラム実装はChapter2に存在しません。");
                break;

        }

    }

    /**
     * 2-1のプログラム。
     * staticファクトリメソッドパターン。インスタンスの生成をコントロールしたり、メソッド名からどのようなインスタンスが返ってくるかわかりやすくなる。
     */
    private void koumoku1(){
        //わかりやすい。 Character wada = new Character("kc","boy");のようにコンストラクタで呼ぶ場合と異なり、メソッド名で誰が呼ばれるかがわかるのも良い。
        //また、コンストラクタで呼ぶ場合と異なり、不要なインスタンス生成を避けることができる。コードの様々な箇所で呼ばれるクラスが存在する場合、このstaticファクトリメソッドパターンを検討してみても良い。
       StaticFactoryMethodPattern.Character wada = StaticFactoryMethodPattern.getWada();
       StaticFactoryMethodPattern.Character hiroshi = StaticFactoryMethodPattern.getHiroshi();
       System.out.println("項目１を実行..."+wada.name+" "+hiroshi.name);

       /*おすすめページ
        http://promamo.com/?p=4204
        */
    }

    /**
     * 2-2のプログラム
     * コンストラクタについて。テレスコーピングパターンではクライアント側のコードが書きづらく、JavaBeansパターンでは複数呼び出しでオブジェクトを作成する必要がある。
     * そレラを組み合わせたビルダーパターンについての実装。
     */
    private void koumoku2(){
        //体重だけ渡さない初期化処理。
        Person wada = new Person.Builder("wada",24).setJob("エンジニア").setSex("男性").setTall(173.8).build();

    }

    /**
     * 2-5のプログラム
     * 不要なオブジェクト生成を避ける - アンチパターンまとめ
     */
    private void koumoku5(){
        //文字列は "xxx" 自体がインスタンスとなるので(オブジェクト型)、 new String("xxx")は、２回インスタンスを生成していることになる。
        String sno = new String("これはだめ");
        String sok = "これはおk";

        //static初期化を常に考える。何回も呼ばれたりインスタンス化されるものについては、static初期化を検討する。
        Date birthDay = new Date();
        birthDay.setDate(1);
        birthDay.setYear(2008);
        birthDay.setMonth(11);  //そもそもここをstatic初期化するべきか悩んだ...
        BadHuman badman = new BadHuman(birthDay);
        badman.isBirthDay();
        GoodHuman goodHuman = new GoodHuman(birthDay);
        goodHuman.isBirthDay();

    }

    /**
     * 2-6のプログラム
     *廃れたオブジェクト参照を取り除く
     *プログラムから参照はされなくなったが、ヒープにオブジェクトが残る例(ガベージコレクタがオブジェクトを拾わない例)
     */
    private void koumoku6(){
        Stack.push("hello1");
        Stack.push("hello2");
        Stack.pop();//hello2はStackから取り出され、呼び出し側からは参照されない。
        System.out.println(Stack.getSize());
    }
}
