package effective.executor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by keiwada on 2017/09/22.
 */
@Component("JavaExecutor")
public class JavaExecutor implements CommandLineRunner{

    /**
     * 実行するEffective-Javaの章を引数にそのプログラムを実行
     */
    @Override
    public void run(String... strings) throws Exception {

        final List<String> paramList = new ArrayList<>(Arrays.asList(strings));

        switch (paramList.size()){
            case 0:
                System.out.println("実行するプログラム番号を指定してください。");
                return;
            case 1:
                System.out.println("実行する項目番号を指定してください。");
                return;

        }



        final String programNum  = paramList.get(0);

        final String koumokuNum  = paramList.get(1);

        JavaProgramManager.callJavaProgram(programNum,koumokuNum);


    }
}
