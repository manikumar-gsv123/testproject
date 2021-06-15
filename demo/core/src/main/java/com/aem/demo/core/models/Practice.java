package com.aem.demo.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Required;


@Model(adaptables=Resource.class)
public class Practice {
	
 
	
	@Inject
	private String  text;
	
	
	@Inject
	private String Desc;
	 
	 
	 public String getText() {
		 return text;
	 }
	 
	 public String getDesc() {
		 return Desc;
	 }
	 
	 
	 
	 
	 }
 
 
 
