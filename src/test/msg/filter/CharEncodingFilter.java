package test.msg.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharEncodingFilter implements Filter {
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
         String e = filterConfig.getInitParameter("encoding");
         if (e==null||"".equals(e.trim())){
             encoding="UTF-8";
         }else{
             encoding = e;
         }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
    }
}
