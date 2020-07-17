package util;

import entity.User;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author burak
 */
@WebFilter("/*")
public class URLFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        User user = (User) req.getSession().getAttribute("valid_user");
        try {
            if (user != null) {

                if (url.contains(user.getMailOnayUrl())) {
                    res.sendRedirect(req.getContextPath() + "/faces/destek.xhtml");
                } else if (url.contains("destek.xhtml") && url.contains(user.getMailOnayUrl())) {
                    res.sendRedirect(req.getContextPath() + "/faces/icerik.xhtml");
                } else {
                    chain.doFilter(request, response);
                }

            } else {
                if (url.contains("destek.xhtml")) {
                    res.sendRedirect(req.getContextPath() + "/faces/icerik.xhtml");
                } else {
                    chain.doFilter(request, response);
                }

            }
        } catch (IOException | ServletException e) {
            System.out.println(e.getMessage());
        }
    }

}
