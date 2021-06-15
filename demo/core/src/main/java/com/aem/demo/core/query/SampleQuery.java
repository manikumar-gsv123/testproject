package com.aem.demo.core.query;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.EventConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;


@Component(service = SampleQuery.class)

public class SampleQuery {
	
	@Reference
	ResourceResolverFactory factory;
	
	 protected final Logger log=LoggerFactory.getLogger(this.getClass());
	 
	 public void getFulltextSearch() {
		 
		 log.info("query example");
		 Map<String, Object> map= new HashMap<String, Object>();
		 
		 map.put(ResourceResolverFactory.SUBSERVICE, "getresolver");
		 
	try {
		ResourceResolver	resolver = factory.getServiceResourceResolver(map);
		 Session session =resolver.adaptTo(Session.class);
		 QueryBuilder builder = resolver.adaptTo(QueryBuilder.class);
		 Map<String,String> pMap = new HashMap<String, String>();
		 pMap.put("path", "/content");
		 pMap.put("property", "jcr:primaryType");
		 pMap.put("p.limit", "-1");
		 pMap.put("property.operation", "exists");
 		 Query query = builder.createQuery(PredicateGroup.create(pMap), session);
 		 
 		 SearchResult result = query.getResult();
 		 List<Hit> hits = result.getHits();
 		 	
		
		
	} catch (LoginException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
		 
	 }
	
	

}
