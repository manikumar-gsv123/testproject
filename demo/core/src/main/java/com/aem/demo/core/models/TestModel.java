package com.aem.demo.core.models;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;

import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class,
defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TestModel {
	
	@ValueMapValue
	private String text;
	
	
	
	
	public String getText() {
		return StringUtils.isNotBlank(this.text)? this.text.toUpperCase() : null;
	}
	public String getText1() {
		return StringUtils.isNotBlank(this.text1)? this.text.toUpperCase() : null;
	}
}
