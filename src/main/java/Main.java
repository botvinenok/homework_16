public class Main {
    public static void main(String[] args) {

        BuilderTest x = new BuilderTest.Builder()
                .withAge("1")
                .withName(411)
                .withSurname(true)
                .build();
        System.out.println(x);

    }
}
