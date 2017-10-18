package effective.program.chapter4.subClasses;

import effective.program.ChapterInterface;

/**
 * Created by keiwada on 2017/10/15.
 */
public class Chapter4 implements ChapterInterface {


    @Override
    public void callProgram(int koumokuNum) {

        switch (koumokuNum){
            case 1:
                koumoku13();
                break;
            default:
                break;
        }
    }

    /**
     * クラスのカプセル化をし、情報隠ぺいすることの重要性。
     * カプセル化を適切にすることでモジュールが適切に分割され、開発時の依存性を削減できたり、テスト時に単体テストやしやすくなる。
     * クライアントがプロパティを直接参照するようなコードを書いて、依存性が悪化するなどを防げる。
     */
    private void koumoku13(){

    }

    private void koumoku14(){
        
    }
}
