package org.thymeleaf.spring4.util.portlet;

import javax.portlet.PortletResponse;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.portlet.context.PortletRequestAttributes;

public class SpringPortletUtil implements IPortletUtil {

	private static SpringPortletUtil INSTANCE;
	
	public static IPortletUtil getInstance() {
		synchronized(SpringPortletUtil.class) {
			if (INSTANCE == null) {
				INSTANCE = new SpringPortletUtil();
			}
			return INSTANCE;
		}
	}
	
	public final boolean isPortletEnv() {
		return true;
	}

	public final String getPortletNamespace() {
    	RequestAttributes attrs = RequestContextHolder.getRequestAttributes();
		if (attrs instanceof PortletRequestAttributes){
			final PortletResponse portletResponse = ((PortletRequestAttributes) attrs).getResponse();
			// TODO log an incident if portletResponse is null!
			return (portletResponse != null) ? portletResponse.getNamespace() : "";
		} else {
			// TODO log an incident!
			return "";
		}
	}
	
}
