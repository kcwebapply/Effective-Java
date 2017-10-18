package effective.program.chapter2.SubClasses;

/**
 * Created by keiwada on 2017/09/23.
 * Personクラスは、Builderクラスを引数にとって初期化される。
 * Builderクラスは必須パラメータとそれ以外の任意のパラメータについて設定が容易かつ簡潔に記述できるためである。
 */
public class Person {
    private String name;
    private int age;
    private String sex;
    private String job;
    private double tall;
    private double weight;

    //Builderクラス。必須のパラメータ以外は適当な値に初期化し、後からSetterでセットする。
    //これにより、Personクラスについてパラメータの設定が容易になる。
    public static class Builder{

        public String name;
        public int age;

        private String sex = "";
        private String job = "";
        private double tall = 0.0;
        private double weight = 0.0;

        public Builder(String name,int age){
                this.name = name;
                this.age = age;
        }

        //オプショナルパタメータ用のセッター。
        public Builder setSex(String sex){
            this.sex = sex;
            return this;
        }

        public Builder setJob(String job){
            this.job = job;
            return this;
        }

        public Builder setTall(double tall){
            this.tall = tall;
            return this;
        }

        public Builder setWeight(double weight){
            this.weight = weight;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

    }
    
    private Person(Builder builder){
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.job = builder.job;
        this.tall = builder.tall;
        this.weight = builder.weight;

    }
}
