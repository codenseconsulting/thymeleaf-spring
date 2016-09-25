package org.thymeleaf.spring4.util.portlet;

/**
 * A utility to resolve if Spring Portlet environement is supported in the
 * current runtime context.
 * 
 * @author mikko
 *
 */
class SpringPortletEnvResolver {

	private static final String PORTLET_RESPONSE_CLASS_NAME = "javax.portlet.PortletResponse";
	private static final String PORTLET_REQUEST_ATTRIBUTES_CLASS_NAME = "org.springframework.web.portlet.context.PortletRequestAttributes";
	
	public static boolean isSpringPortletEnv() {
		// Bind classes lazily
		try {
			Class.forName(PORTLET_RESPONSE_CLASS_NAME);
			Class.forName(PORTLET_REQUEST_ATTRIBUTES_CLASS_NAME);
			return true;
		} catch (ClassNotFoundException e) {
			return false;
		}
	}
}
