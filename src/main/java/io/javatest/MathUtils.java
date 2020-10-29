package io.javatest;

public class MathUtils {
    public int add(int a ,int b){
        return a+b;
    }

    public int multiply(int a,int b){
        return a*b;
    }
    public int divide(int a,int b){
        return a/b;
    }
    public double computeCircleRadius(double radious){
       return Math.PI*Math.pow(radious,2);
        //return 0;
    }
}
