package effective.program.chapter2.SubClasses;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Created by keiwada on 2017/09/22.
 */
public class StaticFactoryMethodPattern {

    private static Character wada = new Character("kc","boy");

    private static Character hiroshi = new Character("hiroshi","boy");

    public static Character getWada(){
        return wada;
    }

    public static Character getHiroshi(){
        return hiroshi;
    }


    @AllArgsConstructor
    @NoArgsConstructor
    public static class Character{
        public String name;
        public String sex;
    }



}


