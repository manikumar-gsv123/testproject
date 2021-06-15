package com.aem.demo.core.schedulers;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;



@Component(service=WorkflowProcess.class, property = {"process.label= testingworkflow"})

public class WorkflowImpl  implements WorkflowProcess{
	
	@Reference
	ResourceResolverFactory rrf;
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public void execute(WorkItem item, WorkflowSession session, MetaDataMap arg2) throws WorkflowException {
		// TODO Auto-generated method stub
		
		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put(ResourceResolverFactory.SUBSERVICE, "myservivetest");
					
			WorkflowData data = item.getWorkflowData();
			String payload=(String) data.getPayload();		
			ResourceResolver resourceresolver = rrf.getServiceResourceResolver(paramMap);		
			Resource resource = resourceresolver.getResource(payload);
			Node node=resource.adaptTo(Node.class);
			Node jcrnode=node.getNode("jcr:content");
			jcrnode.setProperty("wrkflow property", "testing");
			node.getSession().save();
			
			
		}catch(Exception e) {
			
		}
					
		
		
		
		
		
		
		
		
	}
	
	

}
