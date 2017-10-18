package effective.executor;

import effective.program.chapter2.Chapter2;
import effective.program.ChapterInterface;
import effective.program.chapter3.Chapter3;

/**
 * Created by keiwada on 2017/09/22.
 */
public class JavaProgramManager {

    public static void callJavaProgram(String programNum,String koumokuNum){

        final int programN = Integer.valueOf(programNum);
        final int koumokuN = Integer.valueOf(koumokuNum);

        chapter(programN).callProgram(koumokuN);
    }

    private static ChapterInterface chapter(int programNumber) {
        switch (programNumber) {
            case 2:  return new Chapter2();
            case 3:  return new Chapter3();
            default: return null;
        }
    }

}
