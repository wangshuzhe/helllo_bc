package junitT.chapter3;



import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller{
    private Map requestHandlers = new HashMap();

    /**
     * handler 处理器
     * 获取处理器
     * @param request
     * @return
     */
    protected RequestHandler getHandler(Request request) {
        if (!requestHandlers.containsKey(request.getName())) {
            String message = "Cannot find handler for request name [" + request.getName() + "]";
            throw new RuntimeException(message);
        }
        return (RequestHandler) requestHandlers.get(request.getName());
    }
    @Override
    public Response processRequest(Request request) {
        Response response = null;
        try {
            response = getHandler(request).process(request);
        } catch (Exception e) {
            response = new ErrorResponse(request, e);
        }
        return response == null ? null : response;
    }

    @Override
    public void addHandler(Request request, RequestHandler handler) {
        if (requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has already been registered for request name [" + request.getName() + "]");
        } else {
            this.requestHandlers.put(request.getName(), handler);
        }

    }

}
