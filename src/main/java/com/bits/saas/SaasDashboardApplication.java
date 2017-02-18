package com.bits.saas;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * Created by Bharath Kumar Uppala on 10/02/2017.
 */
public class SaasDashboardApplication extends ResourceConfig {

    public SaasDashboardApplication() {
    	
    	super(JacksonFeature.class);
    	packages("com.bits.saas.providers");

    }

}
