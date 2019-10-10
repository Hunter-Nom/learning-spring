/**
 * 
 */
package com.hunter.spring.test;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OSCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		String osName = context.getEnvironment().getProperty("os.name");
		System.out.println(osName);
		if (osName.contains("linux")) {
			return true;
		} else if (osName.contains("windows")) {
			return true;
		}
		return false;
	}

}
