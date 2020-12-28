package io.javabrains;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils mathUtils;

    @BeforeAll
    static  void beforeAllInit(){
        System.out.println("before all");
    }

    @BeforeEach
    void init(){
         mathUtils = new MathUtils();
         System.out.println("before each");
    }

    @AfterEach
    void  cleanup(){
        System.out.println("Cleaning up..");
    }

    @Test
    void testAdd() {

        int expected = 2;
        int actual = mathUtils.add(1,1);
        assertEquals(expected, actual, "The add method failed");
    }

    @Test

    void testDivide(){
        assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1,0), "divide by zero should throw");
    }

    @Test
    void testComputerCircleRadius(){
        assertEquals(314.1592653589793,mathUtils.computeCircleArea(100), "should return right circle area");
    }
}