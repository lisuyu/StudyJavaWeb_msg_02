package test.msg.filter;

import test.msg.model.SystemContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class SystemContextFilter implements Filter {

    int pageSize;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        try {
            pageSize = Integer.parseInt(filterConfig.getInitParameter("pageSize"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            pageSize = 15;
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        try {
            int pageOffset = 1;
            try {
                pageOffset = Integer.parseInt(request.getParameter("pager.offset"));
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            SystemContext.setPageSize(pageSize);
            SystemContext.setPageOffset(pageOffset);
            filterChain.doFilter(servletRequest,servletResponse);
        } finally {
            SystemContext.removePageOffset();
            SystemContext.removePageSize();
        }
    }

    @Override
    public void destroy() {

    }
}
