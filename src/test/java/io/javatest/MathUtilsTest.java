package io.javatest;

import jdk.jfr.Enabled;
import org.junit.After;
import org.junit.jupiter.api.*;
import org.junit.Assert;
import org.junit.Assert.*;
import static org.junit.jupiter.api.Assumptions.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class MathUtilsTest {
    MathUtils mathUtils;
    TestReporter reporter;
    TestInfo info;
    @Nested
    @DisplayName("add method")
    class NestedTest{
        @Test
        @DisplayName("test add method + ")
        @RepeatedTest(2)
        void testAddPoitive(){
          Assertions.assertEquals(2,mathUtils.add(1,1),"The add method should add 2 numbers");
        }
        @Test
        @DisplayName("test add method -")
        void testAddNegative(){
            Assertions.assertEquals(-2,mathUtils.add(-1,-1),"The add method should add 2 numbers");
        }

    }
    @BeforeEach
     void init(TestReporter reporter,TestInfo info){
        this.info=info;
        this.reporter=reporter;
        mathUtils=new MathUtils();
        System.out.println("Created....");
    }
    @BeforeAll
    static void init2(){
        System.out.println("All....");
    }
    @AfterEach
    void destroy(){
        mathUtils=new MathUtils();
        System.out.println("Destroy....");
    }
    @AfterAll
    @DisplayName("Testing destroy ")
    static void destroy2(){
        //mathUtils=new MathUtils();
        System.out.println("Destroy2...");
    }
    @Test
    @DisplayName("Testing add")
    @Tag("Math")
    void testAdd()
    {
       // System.out.println("Test Info name : "+info.getDisplayName()+" tag : "+info.getTags());
        reporter.publishEntry("Test Info name : "+info.getDisplayName()+" tag : "+info.getTags());
        int expected =2;
        int actual=mathUtils.add(1,1);
        //Assert.assertEquals(expected,actual);
        Assert.assertEquals("The add method can add 2 numbers",expected,actual);
        System.out.println("Add");
    }

   @Test
    public void testComputeCircleRadius(){

       Assert.assertEquals("Should return Write circle area",Math.PI,
               mathUtils.computeCircleRadius(1),0);
       System.out.println("Compute");
   }
   @Test
   //@EnabledOnOs(OS.LINUX)
    public void testDivide(){
    boolean isServerUp=false;
     assumeTrue(isServerUp);
     //   Assertions.assertThrows(ArithmeticException.class,()->mathUtils.divide(1,0)
     //   ,"divide by zero");
       System.out.println("Divide");
    }
    @Test
    @DisplayName("Multpliy Test")
    public void testMultiply(){
        Assertions.assertAll(()-> Assertions.assertEquals(4,mathUtils.multiply(2,2)),
                ()-> Assertions.assertEquals(0,mathUtils.multiply(2,0)),
                ()-> Assertions.assertEquals(-2,mathUtils.multiply(2,-1))
                );
    }
    @Test
    @Disabled("Testing disabled")
    void testDisabled(){
        Assertions.fail("the test should be disabled");

    }
   }
