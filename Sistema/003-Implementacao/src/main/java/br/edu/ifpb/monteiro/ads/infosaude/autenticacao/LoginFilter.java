package br.edu.ifpb.monteiro.ads.infosaude.autenticacao;

import br.edu.ifpb.monteiro.ads.infosaude.beans.UserLoginBean;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Vanderlan Gomes<vanderlan.gs@gmail.com>
 * @date 14/04/2015
 */
@WebFilter(urlPatterns = {"/resources/*"})
public class LoginFilter implements Filter {

    @Inject
    private UserLoginBean  usuarioMB;

    @Override
    public void destroy() {
        
        // Método não implementado por falta de necessidade
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (usuarioMB == null || !usuarioMB.isLoggedIn()) {

            String contextPath = ((HttpServletRequest) request).getContextPath();

            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        } else {

            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

         // Método não implementado por falta de necessidade
        
    }
}
