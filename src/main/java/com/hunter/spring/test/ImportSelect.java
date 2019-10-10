/**
 * 
 */
package com.hunter.spring.test;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**   
* @Title: ImportSelect.java 
* @Package com.hunter.spring.test 
* @Description: TODO(用一句话描述该文件做什么) 
* @author nom zhengguangnong@gmail.com   
* @date Sep 23, 2019 2:27:43 PM 
* @version V1.0   
*/
public class ImportSelect implements ImportSelector{

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		// TODO Auto-generated method stub
		return null;
	}

}
