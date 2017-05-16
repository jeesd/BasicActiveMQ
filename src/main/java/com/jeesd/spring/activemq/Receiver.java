package com.jeesd.spring.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 整合spring+MQ
 * @author song
 *
 */
public class Receiver {

	
    public static void main(String[] args) {
        @SuppressWarnings({ "resource", "unused" })
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");   
    }
}
