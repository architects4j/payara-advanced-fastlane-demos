package my.compary.cdi.demo.extension;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessBean;
import java.util.LinkedHashSet;
import java.util.Set;

public class StartupBeanExtension implements Extension {

    private static final Lo
    private final Set<Bean<?>> startupBeans = new LinkedHashSet<>();


    <X> void processBean(@Observes ProcessBean<X> event) {
        if (event.getAnnotated().isAnnotationPresent(StartUp.class) &&
                event.getAnnotated().isAnnotationPresent(ApplicationScoped.class)) {
            startupBeans.add(event.getBean());
        }
    }

    void afterDeploymentValidation(@Observes AfterDeploymentValidation event, BeanManager manager) {
        for (Bean<?> bean : startupBeans) {
            // the call to toString() is a cheat to force the bean to be initialized
            manager.getReference(bean, bean.getBeanClass(), manager.createCreationalContext(bean)).toString();
        }
    }
}