package com.bits.saas;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bits.saas.service.IEnterpriseService;

/**
 * Created by Bharath Kumar Uppala on 12/02/2017.
 */
public class TestServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -256255825131944098L;
	private static final Logger LOG = LogManager.getLogger(TestServlet.class);
	public IEnterpriseService enterpriseService;

	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		LOG.info("Setting enterpriseService::"+enterpriseService);
		this.enterpriseService = enterpriseService;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in Post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("in get");
    	//enterpriseService = new EnterpriseServiceImpl();
    	//this.enterpriseService.getAll();
    	System.out.println(enterpriseService);
    }
}
