import io.javatest.MathUtils;

public class Main {
    public static void main(String[] args) {
        MathUtils calculator=new MathUtils();
        int sum=calculator.add(0,1);
        if(sum!=1)
            System.out.println("Test Failed");

    }
}
