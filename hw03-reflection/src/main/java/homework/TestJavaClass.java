package homework;

import java.nio.file.AccessDeniedException;

public class TestJavaClass {

    public TestJavaClass() {
    }

    @Before
    public void before1() {

    }

    @Before
    public void before2() {

    }

    @After
    public void after1() {

    }

    @After
    public void after2() {

    }

    @Test
    public void method1() {

    }

    @Test
    public void method2() throws Exception {
        throw new AccessDeniedException("No access");
    }

    @Test
    public void method3() {

    }
}
