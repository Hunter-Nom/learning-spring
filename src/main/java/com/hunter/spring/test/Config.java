/**
 * 
 */
package com.hunter.spring.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Title: Config.java
 * @Package com.hunter.spring.test
 * @Description: TODO(用一句话描述该文件做什么)
 * @author nom zhengguangnong@gmail.com
 * @date Sep 10, 2019 3:23:57 PM
 * @version V1.0
 */
@Configuration
@ComponentScan(value = "com.hunter.spring.test")
@Import(value = { ImportBenDefinition.class })
public class Config {

	@Bean
	@Conditional(OSCondition.class)
	public User windows() {
		System.out.println("windows");
		return new User();
	}

	@Bean
	@Conditional(OSCondition.class)
	public User linux() {
		System.out.println("linux");
		return new User();
	}

	@Bean
	// @Conditional(OSCondition.class)
	public User Mac() {
		System.out.println("Mac");
		return new User();
	}

}
