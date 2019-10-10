/**
 * 
 */
package com.hunter.spring.test.scan;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

/**
 * @Title: ClassScanAnnotation.java
 * @Package com.hunter.spring.test.scan
 * @Description: TODO(用一句话描述该文件做什么)
 * @author nom zhengguangnong@gmail.com
 * @date Sep 26, 2019 9:50:06 PM
 * @version V1.0
 */
public class ClassScanAnnotation {

	private String CLASSPATH_URL_PREFIX = "classpath:";

	private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";

	public void parseFlowFilterAnnotationHandler() throws IOException, ClassNotFoundException, LinkageError {
		String basePath = "com.hunter.spring.test".replaceAll("\\.", File.separator);
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		String packageSearchPath = CLASSPATH_URL_PREFIX + basePath;// + File.separator + DEFAULT_RESOURCE_PATTERN;
		Set<Class<?>> classes = new HashSet<>();
		findClassesByFile("com.hunter.spring.test", packageSearchPath, classes);
		System.out.println(classes.size());
	}

	/**
	 * 扫描包路径下的所有class文件
	 *
	 * @param pkgName 包名
	 * @param pkgPath 包对应的绝对地址
	 * @param classes 保存包路径下class的集合
	 */
	private static void findClassesByFile(String pkgName, String pkgPath, Set<Class<?>> classes) {
		File dir = new File(pkgPath);
		if (!dir.exists() || !dir.isDirectory()) {
			return;
		}

		// 过滤获取目录，or class文件
		File[] dirfiles = dir.listFiles(pathname -> pathname.isDirectory() || pathname.getName().endsWith("class"));

		if (dirfiles == null || dirfiles.length == 0) {
			return;
		}

		String className;
		Class clz;
		for (File f : dirfiles) {
			if (f.isDirectory()) {
				findClassesByFile(pkgName + "." + f.getName(), pkgPath + "/" + f.getName(), classes);
				continue;
			}

			// 获取类名，干掉 ".class" 后缀
			className = f.getName();
			className = className.substring(0, className.length() - 6);

			// 加载类
			clz = loadClass(pkgName + "." + className);
			if (clz != null) {
				classes.add(clz);
			}
		}
	}

	private static Class<?> loadClass(String fullClzName) {
		try {
			return Thread.currentThread().getContextClassLoader().loadClass(fullClzName);
		} catch (ClassNotFoundException e) {
//			log.error("load class error! clz: {}, e:{}", fullClzName, e);
		}
		return null;
	}
}
