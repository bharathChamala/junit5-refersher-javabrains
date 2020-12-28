package io.javabrains;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayName("When Running MathUtils")
class MathUtilsTest {

    MathUtils mathUtils;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static  void beforeAllInit(){
        System.out.println("before all");
    }

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
         this.testInfo = testInfo;
         this.testReporter = testReporter;
         mathUtils = new MathUtils();
         System.out.println("before each");
        testReporter.publishEntry("Running "+ testInfo.getDisplayName() + " with tags " + testInfo.getTags());

    }

    @AfterEach
    void  cleanup(){
        System.out.println("Cleaning up..");
    }

    @Nested
    @DisplayName("Add method")
    @Tag("Math")
    class AddTest{
        @Test
        @DisplayName("When adding two positive numbers")
        void testAddPositive() {
            int expected = 2;
            int actual = mathUtils.add(1,1);
            assertEquals(expected, actual, () -> "should return sum"+ expected + "but returned"+ actual);
        }

        @Test
        @DisplayName("Testing Add Negative Method")
        void testAddNegative() {

            assertEquals(-2, mathUtils.add(-1,-1), "The add method failed");
        }
    }



    @Test
    @Tag("Math")
    void testDivide(){
        boolean isServerUp = true;
        assumeTrue(isServerUp);
        assertThrows(ArithmeticException.class, ()-> mathUtils.divide(1,0), "divide by zero should throw");
    }

    @Test
    @DisplayName("multiply method")
    @Tag("Math")
    void testMultiply(){
        testReporter.publishEntry("Running "+ testInfo.getDisplayName() + " with tags " + testInfo.getTags());
        assertAll(
                () -> assertEquals(4, mathUtils.multiply(2,2)),
                () -> assertEquals(6, mathUtils.multiply(2,3))

        );
    }

    @RepeatedTest(3)
    @EnabledOnOs(OS.WINDOWS)
    @Tag("Circle")
    void testComputerCircleRadius(RepetitionInfo repetitionInfo){

        assertEquals(314.1592653589793,mathUtils.computeCircleArea(100), "should return right circle area");
    }

    @Test
    @Disabled
    @DisplayName("TDD Should not run")
    void testDisabled(){
        fail("This test should be failed");
    }

    //Done - 28th Dec,2020
}