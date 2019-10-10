/**
 * 
 */
package com.hunter.spring.test.entity;

import javax.annotation.Resource;

import com.hunter.spring.test.annotation.FlowFilter;

public class Hello implements AutoCloseable{

	@FlowFilter(value = "add")
	@Resource
	public void add() {
		System.out.println(">>>>>>>>>>>");
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}

}
