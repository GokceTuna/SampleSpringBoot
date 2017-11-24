package com.sample.ui.welcome;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.shared.welcome.IWelcomePojo;
import com.sample.shared.welcome.WelcomeConstants;
import com.sample.ui.BaseController;
import com.sample.ui.BeanNames;
import com.sample.ui.JaxRsCaller;

@Controller(BeanNames.BEAN_WELCOME_CONTROLLER)
@RequestMapping(WelcomeConstants.PATH_TO_CONTROLLER_ROOT)
public class WelcomeController extends BaseController {

	@Autowired
	@Qualifier(BeanNames.BEAN_JAX_RS_CALLER)
	private JaxRsCaller mOBJaxRsCaller;

	/**
	 * Simply selects the home view to render by returning its model object.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = { PATH_ROOT,
			WelcomeConstants.PATH_TO_VIEW_WITH_PARAM_WELCOME_NAME })
	public Model welcome(Model model,
			@RequestParam(value = WelcomeConstants.PARAM_SUB_VIEW_WELCOME_NAME, required = false) String pSTName)
			throws Exception {

		IWelcomePojo lOBWelcomeServiceResponse = getWelcomeServiceResponse(pSTName);
		model.addAttribute(WelcomeConstants.VIEW_RESPONSE_WELCOME, lOBWelcomeServiceResponse);

		return model;
	}

	private String getWelcomeServiceUrl(String pSTName) {
		StringBuilder lOBUrl = new StringBuilder(WelcomeConstants.PATH_FULL_TO_SERVICE_WELCOME);
		if (pSTName != null && !pSTName.isEmpty()) {
			lOBUrl.append(SLASH).append(pSTName);
		}
		return lOBUrl.toString();
	}

	private IWelcomePojo getWelcomeServiceResponse(String pSTName) throws Exception {
		IWelcomePojo lOBWelcomeServiceResponse = (IWelcomePojo) getApplicationContext()
				.getBean(WelcomeConstants.POJO_NAME_WELCOME);

		lOBWelcomeServiceResponse = (IWelcomePojo) mOBJaxRsCaller.getResponse(getWelcomeServiceUrl(pSTName),
				MediaType.APPLICATION_JSON, lOBWelcomeServiceResponse.getClass());

		return lOBWelcomeServiceResponse;

	}

}
