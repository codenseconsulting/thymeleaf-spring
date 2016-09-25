package org.thymeleaf.spring4.util.portlet;

import javax.portlet.PortletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.portlet.context.PortletRequestAttributes;
import org.thymeleaf.util.portlet.impl.AbstractPortletUtil;


public class SpringPortletUtil extends AbstractPortletUtil {

	public final boolean isSupported() {
		return SpringPortletEnvResolver.isSpringPortletEnv();
	}
	
	public final boolean isPortletEnv() {
		return isSupported();
	}

	@Override
	protected final PortletResponse getPortletResponse() {
		RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
		if (attrs instanceof PortletRequestAttributes){
			return ((PortletRequestAttributes) attrs).getResponse();
		} else {
			return null;
		}
	}
	
	
}
