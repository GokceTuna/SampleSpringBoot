package com.sample.service.welcome;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.sample.service.BaseService;
import com.sample.shared.welcome.IWelcomePojo;
import com.sample.shared.welcome.WelcomeConstants;
import com.sample.shared.welcome.WelcomeUtilities;

@Service
@Path(WelcomeConstants.PATH_TO_SERVICE_ROOT)
public class WelcomeService extends BaseService {

	@GET
	@Path(WelcomeConstants.PATH_TO_SUB_SERVICE_WITH_PARAM_WELCOME_NAME)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response welcome(@PathParam(WelcomeConstants.PARAM_SUB_SERVICE_WELCOME_NAME) String pSTName) {

		IWelcomePojo lOBWelcomePojo = (IWelcomePojo) getApplicationContext()
				.getBean(WelcomeConstants.POJO_NAME_WELCOME);

		lOBWelcomePojo.setMessage(WelcomeUtilities.getInstance().getMessage(pSTName));
		lOBWelcomePojo.setDate(new Date());

		return Response.status(Response.Status.CREATED.getStatusCode()).entity(lOBWelcomePojo).build();
	}

	@GET
	@Path(WelcomeConstants.PATH_TO_SUB_SERVICE_WELCOME)
	@Produces({ MediaType.APPLICATION_JSON })
	public Response welcome() {
		return welcome(null);
	}
}
