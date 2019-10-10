/**
 * 
 */
package com.hunter.spring.test.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Title: MyProcessor.java
 * @Package com.hunter.spring.test.processor
 * @Description: TODO(用一句话描述该文件做什么)
 * @author nom zhengguangnong@gmail.com
 * @date Sep 13, 2019 1:13:33 PM
 * @version V1.0
 */
@Component
public class MyProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("初始化之前 " + beanName + " >>>" + bean);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("初始化之后 " + beanName + " >>>" + bean);
		return bean;
	}

}
