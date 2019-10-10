package com.hunter.spring.test;

import org.springframework.beans.factory.FactoryBean;

public class NomFactoryBean implements FactoryBean<Pig> {

	@Override
	public Pig getObject() throws Exception {
		return new Pig();
	}

	@Override
	public Class<?> getObjectType() {
		return Pig.class;
	}

}
