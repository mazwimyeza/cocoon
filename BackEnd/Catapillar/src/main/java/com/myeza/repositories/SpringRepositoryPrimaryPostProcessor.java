package com.myeza.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.repository.core.support.RepositoryFactoryInformation;
import org.springframework.stereotype.Component;

@Component
public class SpringRepositoryPrimaryPostProcessor implements BeanFactoryPostProcessor {
    public static final String REPOSITORY_INTERFACE_PROPERTY = "ProfileRepository";


    protected List<BeanDefinition> getRepositoryBeans(ConfigurableListableBeanFactory beanFactory) {
        List<BeanDefinition> springDataRepositoryDefinitions = new ArrayList<>();
        for (String beanName : beanFactory.getBeanDefinitionNames()) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);

            String beanClassName = beanDefinition.getBeanClassName();
            try {
                Class<?> beanClass = Class.forName(beanClassName);
                if (isSpringDataMongoRepository(beanClass)) {
                    springDataRepositoryDefinitions.add(beanDefinition);
                }
            } catch (ClassNotFoundException e) {
                throw new ApplicationContextException(String.format("Error when trying to create instance of %s", beanClassName), e);
            }
        }

        return springDataRepositoryDefinitions;
    }

  protected void makeRepositoriesPrimary(List<BeanDefinition> repositoryBeans) {
    for (BeanDefinition repositoryBeanDefinition : repositoryBeans) {
    	String repositoryInterface = (String) repositoryBeanDefinition.getAttribute("factoryBeanObjectType");            if (isPrimary(repositoryInterface)) {
               // log.debug("Making site repository bean primary, class: {}", repositoryInterface);
                repositoryBeanDefinition.setPrimary(true);
            }
    }
}

protected boolean isSpringDataMongoRepository(Class<?> beanClass) {
    return RepositoryFactoryInformation.class.isAssignableFrom(beanClass);
}

private boolean isPrimary(String repositoryInterface) {
    return AnnotationUtils.findAnnotation(getClassSafely(repositoryInterface), Primary.class) != null;
}

    private Class<?> getClassSafely(String repositoryInterface) {
        try {
            return Class.forName(repositoryInterface);
        } catch (ClassNotFoundException e) {
            throw new ApplicationContextException(String.format("Error when trying to create instance of %s", repositoryInterface), e);
        }
    }

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		makeRepositoriesPrimary(getRepositoryBeans(beanFactory));
		
	}
	
}