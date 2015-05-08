package br.edu.ifpb.monteiro.ads.infosaude.autenticacao;

import br.edu.ifpb.monteiro.ads.infosaude.beans.UserLoginBean;
import br.edu.ifpb.monteiro.ads.infosaude.dao.util.JsfUtil;
import java.io.IOException;
import java.util.Map;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
    private UserLoginBean usuarioMB;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        usuarioMB = (UserLoginBean) getSessionAttribute("usuarioBean");
        
        if (usuarioMB == null || !usuarioMB.isLoggedIn()) {

            String contextPath = ((HttpServletRequest) request).getContextPath();

            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        } else {

            chain.doFilter(request, response);
        }
    }

    public static Object getSessionAttribute(String att) {

        try {

            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            if (ec != null) {

                Map attrMap = ec.getSessionMap();
                if (attrMap != null) {

                    return attrMap.get(att);

                } else {
                    return null;
                }

            }
        } catch (Exception e) {
            
            JsfUtil.addErrorMessage("Erro ao iniciar sessão de usuário");
        }
            return null;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
