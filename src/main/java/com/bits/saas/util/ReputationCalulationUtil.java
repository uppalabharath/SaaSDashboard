package com.bits.saas.util;

import com.bits.saas.pojo.Customer;

public class ReputationCalulationUtil {
	
	public static float calculateReputation(Customer customer){
		return customer.getReputation()/100;
	}

}
