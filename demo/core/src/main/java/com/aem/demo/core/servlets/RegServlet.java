package com.aem.demo.core.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.osgi.framework.Constants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;

@Component(service = Servlet.class,immediate = true,property = {
        Constants.SERVICE_DESCRIPTION +"=servlet for login",
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.paths=" + "/bin/regservlet"

})


public class RegServlet extends SlingAllMethodsServlet {

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {


        final Logger log= LoggerFactory.getLogger(RegServlet.class);


        ResourceResolver resolver = request.getResourceResolver();
        Session session=  resolver.adaptTo(Session.class);
        Resource resource=resolver.getResource("/content/testpage");
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        Node node = null;
        if (resource != null) {
            node = resource.adaptTo(Node.class);
        }
        else
            response.getWriter().println("resource doesnot exists");

        try {
            Node eachNode=node.addNode(username, "nt:unstructured");
            session.save();
            eachNode.setProperty("username", username);
            eachNode.setProperty("password", password);
            session.save();
            log.info("username enter"+ node.setProperty("username", username) );

        } catch (RepositoryException e) {
            log.info("venki",e);
        }


    }
}