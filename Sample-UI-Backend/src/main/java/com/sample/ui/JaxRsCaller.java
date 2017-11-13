package com.sample.ui;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(BeanNames.BEAN_JAX_RS_CALLER)
public class JaxRsCaller {

	@Autowired
	@Qualifier(BeanNames.BEAN_JAX_RS_CLIENT_POOL)
	private CommonsPool2TargetSource mOBJaxRsClientPool;

	public JaxRsCaller() {
		super();
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Object getResponse(String pSTUrl, String pSTMediaType, Class pOBResponseClass) throws Exception {
		Client lOBJaxRsClient = (Client) mOBJaxRsClientPool.getTarget();

		WebTarget lOBWebTarget = lOBJaxRsClient.target(pSTUrl);
		Object lOBResponse = lOBWebTarget.request(pSTMediaType).get(pOBResponseClass);

		mOBJaxRsClientPool.releaseTarget((Object) lOBJaxRsClient);

		return lOBResponse;
	}
}
