public class BuilderTest {

    private String age;
    private int name;
    private boolean surname;

    public static class Builder{
        private BuilderTest testBuilder;

        public Builder(){
            testBuilder = new BuilderTest();
        }

        public Builder withAge(String age){
            testBuilder.age = age;
            return this;
        }

        public Builder withName(int name){
            testBuilder.name = name;
            return this;
        }

        public Builder withSurname(boolean surname){
            testBuilder.surname = surname;
            return this;
        }

        public BuilderTest build(){
            return testBuilder;
        }

    }

}
