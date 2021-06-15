package com.aem.demo.core.servlets;

import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.resource.Resource;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;





@Component(service = Servlet.class, property = {Constants.SERVICE_DESCRIPTION +  "=sling demo serlvet",
		"sling.servlet.methods="  + HttpConstants.METHOD_GET, "sling.model.path=" + "/bin/slingModel/demo"})
public class SlingModelServlet extends SlingSafeMethodsServlet {
	
	
	private static final long serialVersionUID = 7558680464517017317L;
	
	private static final Logger log= LoggerFactory.getLogger(SlingModelServlet.class);
	
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {
	
		log.info("process starts");
		
		 ResourceResolver resolver=request.getResourceResolver();
		 Resource resource=(Resource) resolver.getResource("/content/vpage/jcr:content/container 1/helloworld");
		 
		
		
		
	}

}
