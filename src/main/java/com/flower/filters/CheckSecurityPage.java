package com.flower.filters;


import com.flower.User;
import com.flower.dao.DAO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by user on 04.12.2015.
 */
public class CheckSecurityPage implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        //NOOP
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //filterChain.doFilter(servletRequest, servletResponse);
        User user = new User();
        HttpSession session = ((HttpServletRequest) request).getSession();
        try {
            if (session != null) {

                Integer iduser = (Integer) session.getAttribute("iduser");
                String hash = (String) session.getAttribute("session");

                if ((iduser != null) || (hash != null)) {

                    DAO CheckUserAuthentication = new DAO();
                    filterChain.doFilter(request, response);
                    user = CheckUserAuthentication.checkUserAuthentication(iduser, hash);
                    if (user.getIdUser() == 0) {
                        ((HttpServletResponse) response).sendRedirect("../login.jsp");
                    } else {
                        return;
                    }

                }

                /*if (((Integer) session.getAttribute("iduser")).equals("true") && ((String) session.getAttribute("session")).equals("true")) {
                    filterChain.doFilter(request, response);
                    return;
                }*/
            }
        } catch (NullPointerException e) {
            //NOOP
        }
        ((HttpServletResponse) response).sendRedirect("../login.jsp");

    }

    public void destroy() {
        //NOOP
    }
}
