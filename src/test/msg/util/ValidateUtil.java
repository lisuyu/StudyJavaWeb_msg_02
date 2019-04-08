package test.msg.util;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ValidateUtil {
    public static boolean validateNull(HttpServletRequest request,String[] fields){
        boolean validate = true;
        Map<String,String> errorMsg = new HashMap<String,String>();
        for (String field:fields){
            String value = request.getParameter(field);
            if (value==null||"".equals(value.trim())) {
                errorMsg.put(field, field + "不能为空");
                System.out.println(field+"为空了！");
                validate = false;
            }
        }
        if (!validate)
            request.setAttribute("errorMsg",errorMsg);
        return validate;
    }

    public static String showError(HttpServletRequest request,String field){
        Map<String,String> errorMsg = (Map<String,String>)request.getAttribute("errorMsg");
        if (errorMsg==null) return null;
        String msg = errorMsg.get(field);
        if (msg==null) return " ";
        return msg;
    }
}
