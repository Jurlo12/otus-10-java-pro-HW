package homework;


import java.lang.reflect.InvocationTargetException;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        TestJavaClass testJavaClass = new TestJavaClass();
        TestAnnotationProcessor.testProcessor(testJavaClass);

    }
}