package homework;

import java.lang.reflect.Method;

public class TestAnnotationProcessor {
    public static void testProcessor (Object o) throws Exception {
        Class cls = o.getClass();
        StringBuilder success = new StringBuilder();
        StringBuilder unsuccessful = new StringBuilder();
        for (Method m : cls.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                Class clsTest = o.getClass();
                for (Method n : clsTest.getDeclaredMethods()) {
                    if (n.isAnnotationPresent(Before.class)) {
                        n.invoke(o);
                    }
                }
                try {
                    m.invoke(o);
                    success.append("1");
                }
                catch (Exception e) {
                    unsuccessful.append("1");
                }
                for (Method s : clsTest.getDeclaredMethods()) {
                    if (s.isAnnotationPresent(After.class)) {
                        s.invoke(o);
                    }
                }
            }
        }
        System.out.println("Выполнено успешно: " + success.length());
        System.out.println("Выполнено неуспешно: " + unsuccessful.length());
        System.out.println("Выполнено всего: " + (success.length() + unsuccessful.length()));
    }
}
