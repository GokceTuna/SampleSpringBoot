package com.sample.ui.welcome;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sample.shared.Constants;
import com.sample.shared.welcome.WelcomePojo;
import com.sample.shared.welcome.WelcomeUtilities;
import com.sample.ui.BaseController;
import com.sample.ui.BeanNames;
import com.sample.ui.JaxRsCaller;

@Controller(BeanNames.BEAN_WELCOME_CONTROLLER)
@RequestMapping(Constants.Controllers.WelcomeController.PATH)
public class WelcomeController extends BaseController {

	@Autowired
	@Qualifier(BeanNames.BEAN_JAX_RS_CALLER)
	private JaxRsCaller mOBJaxRsCaller;

	protected final JaxRsCaller getJaxRsCaller() {
		return mOBJaxRsCaller;
	}

	/**
	 * Simply selects the home view to render by returning its model object.
	 * 
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET, value = { PATH_ROOT,
			Constants.Controllers.WelcomeController.Welcome.PATH_NAME,
			Constants.Controllers.WelcomeController.Welcome.PATH_ID })
	public Model welcome(Model model,
			@RequestParam(value = Constants.Controllers.WelcomeController.Welcome.PARAM_NAME, required = false) String pSTName,
			@RequestParam(value = Constants.Controllers.WelcomeController.Welcome.PARAM_ID, required = false) Integer pINId)
			throws Exception {

		WelcomePojo lOBWelcomeServiceResponse;
		if (pINId != null) {
			lOBWelcomeServiceResponse = getWelcomeServiceResponse(pINId, WelcomeUtilities.TYPE_ID);
		} else {
			lOBWelcomeServiceResponse = getWelcomeServiceResponse(pSTName, WelcomeUtilities.TYPE_NAME);
		}
		model.addAttribute(Constants.Controllers.WelcomeController.Welcome.RESPONSE, lOBWelcomeServiceResponse);

		return model;
	}

	/**
	 * 
	 * @param pOBParameter
	 * @param pinType
	 * @return
	 * @throws Exception
	 * 
	 *             Calls related welcome service and returns the response.
	 */
	private WelcomePojo getWelcomeServiceResponse(Object pOBParameter, int pinType) throws Exception {
		String lSTServiceUrl = WelcomeUtilities.getInstance().getWelcomeServiceUrl(pOBParameter, pinType);

		WelcomePojo lOBWelcomeServiceResponse = (WelcomePojo) getJaxRsCaller().getResponse(lSTServiceUrl,
				MediaType.APPLICATION_JSON, WelcomePojo.class);

		return lOBWelcomeServiceResponse;
	}

}
