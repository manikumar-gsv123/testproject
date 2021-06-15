package com.aem.demo.core.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.osgi.framework.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, immediate = true,
property={
        Constants.SERVICE_DESCRIPTION +"=login test",
        "sling.servlet.methods="+ HttpConstants.METHOD_GET,
        "sling.servlet.paths="+"/bin/logintest"
}

)
public class LoginServlet extends SlingAllMethodsServlet {
@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {

ResourceResolver resolver=request.getResourceResolver();
Resource resource=resolver.getResource("/content/testpage");
Iterator<Resource> child=  resource.listChildren();
String username=request.getParameter("username");
String password=request.getParameter("password");
boolean flag= false;
while (child.hasNext()){

 Resource eachRef = child.next();
 Node eachNode=eachRef.adaptTo(Node.class);
 try {
     if(eachNode.hasProperty("username") && eachNode.hasProperty("password")){
         String propFromNode=eachNode.getProperty("username").getString();
         String propFromPass=eachNode.getProperty("password").getString();
         if(username.trim().equals(propFromNode)&& password.trim().equals(propFromPass)){
           flag=true;
           break;


         }

     }
 } catch (RepositoryException e) {
     e.printStackTrace();
 }


}
if(flag){
 response.getWriter().write("success");

}else{
 response.getWriter().write("fail");
}






}
}
