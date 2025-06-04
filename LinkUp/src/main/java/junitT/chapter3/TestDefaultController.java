package junitT.chapter3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestDefaultController {
    private DefaultController controller;
    private Request request;
    private RequestHandler handler;

    /*
        @before 发生在执行 test 方法之前
        @after 发生在这执行 test 方法之后
        且 这两组注释只能修饰public方法, beforeclass 和 afterclass 只能修饰静态公有方法
     */
    @Before
    public void instantiate() throws Exception {
        controller = new DefaultController();
        request = new SampleRequest();
        handler = new SampleHandler();
        controller.addHandler(request, handler);
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
/*
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();
        controller.addHandler(request, handler);
        RequestHandler handler1 = controller.getHandler(request);
        assertSame("Handler we set in controller should be the " +
                "same handler we get", handler1, handler);
*/
        RequestHandler handler2 = controller.getHandler(request);
        assertSame(handler2, handler);
    }

    @Test
    public void testProcessRequest() {
/*
        SampleRequest request = new SampleRequest();
        SampleHandler handler = new SampleHandler();
        controller.addHandler( request, handler);
        Response response = controller.processRequest(request);
        assertNotNull("Response should not be null", response);
        assertEquals("Response should be of type SampleResponse", SampleResponse.class, response.getClass());
*/
        Response response = controller.processRequest(request);
        assertNotNull("Must not return a null response", response);
        assertEquals("Response shoudle be of type SampleResponse", SampleResponse.class, response.getClass());
    }

    private class SampleRequest implements Request {
        private String name;

        public SampleRequest() {
            this.name = "test";
        }

        public SampleRequest(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class SampleHandler implements RequestHandler {

        @Override
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {
        private static final String NAME = "test";

        public String getName() {
            return NAME;
        }
    }

    private class SamoleExceptionHandler implements RequestHandler {
        @Override
        public Response process(Request request) throws Exception {
            throw new Exception("error processing request");
        }
    }

    @Test
    public void testProcessRequestAnswersErrorException() {
        SampleRequest request1 = new SampleRequest("test2");
        SamoleExceptionHandler handler1 = new SamoleExceptionHandler();
        controller.addHandler(request1, handler1);
        Response response = controller.processRequest(request1);
        assertNotNull("Must not return a null response", response);
        assertEquals(ErrorResponse.class, response.getClass());
    }

    /**
     * 测试方法未定义
     * 如若方法会抛出异常，可以使用expected属性执行要抛出的异常类型
     */
    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {
        SampleRequest request1 = new SampleRequest("testNotDefined");
        controller.getHandler(request1);
    }

    /**
     * 加上expected 后，程序未返回异常。测试也会报错
     */
    @Test(expected = RuntimeException.class)
    public void testAddRequestDuplicateName() {
        SampleRequest request1 = new SampleRequest();
        SampleHandler sampleHandler = new SampleHandler();
        controller.addHandler(request1, sampleHandler);
    }
}
