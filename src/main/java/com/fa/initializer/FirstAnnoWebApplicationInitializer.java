package com.fa.initializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class FirstAnnoWebApplicationInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
	
		XmlWebApplicationContext rootApplicationContext=null;
		XmlWebApplicationContext servletApplicationContext=null;
		ContextLoaderListener contextListner=null;
		DispatcherServlet ds=null;
		
		rootApplicationContext=new XmlWebApplicationContext();
		rootApplicationContext.setConfigLocation("/WEB-INF/application-context.xml");
		
		contextListner=new ContextLoaderListener(rootApplicationContext);
		
		servletContext.addListener(contextListner);

		
		servletApplicationContext=new XmlWebApplicationContext();
		servletApplicationContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
		ds=new DispatcherServlet(servletApplicationContext);
		
		ServletRegistration.Dynamic dynamic=servletContext.addServlet("dispatcherservlet", ds);
		dynamic.addMapping("*.htm");
		dynamic.setLoadOnStartup(2);
	}

}
