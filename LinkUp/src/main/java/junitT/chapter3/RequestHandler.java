package junitT.chapter3;

public interface RequestHandler {
    Response process(Request request) throws Exception;
}
