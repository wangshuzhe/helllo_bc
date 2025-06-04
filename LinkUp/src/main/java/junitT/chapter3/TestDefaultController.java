package junitT.chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDefaultController {
    private
    DefaultController controller;
    /*
        @before 发生在执行 test 方法之前
        @after 发生在这执行 test 方法之后
        且 这两组注释只能修饰public方法, beforeclass 和 afterclass 只能修饰静态公有方法
     */
    @Before
    public void instantiate() throws Exception {
        controller = new DefaultController();
    }

    @Test
    public void testMethod() {
        throw new RuntimeException("implement me");
    }

    /**
     * 测试添加的Request 是否是同一个对象
     */
    @Test
    public void testAddHandler() {
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();
        controller.addHandler(request, handler);
        RequestHandler handler1 = controller.getHandler(request);
        assertSame("Handler we set in controller should be the " +
                "same handler we get", handler1, handler);
    }

    @Test
    public void testProcessRequest() {
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();
        controller.addHandler( request, handler);
        Response response = controller.processRequest(request);
        assertNotNull("Response should not be null", response);
        assertEquals("Response should be of type SampleResponse", SampleResponse.class, response.getClass());
    }
    private class SampleRequest implements Request {

        @Override
        public String getName() {
            return "Test";
        }
    }
    private class SampleHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {

    }
}
