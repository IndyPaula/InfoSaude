package br.edu.ifpb.monteiro.ads.infosaude.dao.util;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Jefferson Emanuel Caldeira da Silva <jefferson.ecs@gmail.com>
 * @date 07/05/2015
 */
public class CDIServiceLocator {

    private static BeanManager getBeanManager() {
        try {
            InitialContext initialContext = new InitialContext();
            return (BeanManager) initialContext.lookup("java:comp/BeanManager");
        } catch (NamingException ex) {
            Logger.getLogger(InitialContext.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("BeanManager não encontrado.");
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz) {
        BeanManager bm = getBeanManager();
        Set<Bean<?>> beans = (Set<Bean<?>>) bm.getBeans(clazz);

        if (beans == null || beans.isEmpty()) {
            return null;
        }

        Bean<T> bean = (Bean<T>) beans.iterator().next();

        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        T o = (T) bm.getReference(bean, clazz, ctx);

        return o;
    }

}
