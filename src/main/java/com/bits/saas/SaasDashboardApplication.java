package com.bits.saas;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.bits.saas.filter.CORSResponseFilter;

/**
 * Created by Bharath Kumar Uppala on 10/02/2017.
 */
public class SaasDashboardApplication extends ResourceConfig {

    public SaasDashboardApplication() {
    	
    	super(JacksonFeature.class);
    	register(CORSResponseFilter.class);
    	packages("com.bits.saas.providers");

    }

}
