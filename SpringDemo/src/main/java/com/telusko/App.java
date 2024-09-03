package com.telusko;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.FileSystemResource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        BeanFactory factory = new XmlBeanFactory(new FileSystemResource(spring.xml));
        Alien obj = (Alien)factory.getBean("alien");
        obj.code();
    }
}
