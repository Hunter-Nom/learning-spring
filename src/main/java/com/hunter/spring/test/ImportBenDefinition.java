/**
 * 
 */
package com.hunter.spring.test;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.wiring.BeanConfigurerSupport;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Title: ImportBenDefinition.java
 * @Package com.hunter.spring.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author nom zhengguangnong@gmail.com
 * @date Sep 23, 2019 2:40:20 PM
 * @version V1.0
 */
public class ImportBenDefinition implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		RootBeanDefinition beanDefinition = new RootBeanDefinition(Pig.class);
		registry.registerBeanDefinition("pig", beanDefinition);
	}

}
