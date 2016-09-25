package org.thymeleaf.spring4.util.portlet;

public class PortletUtilFactory {
	
	static class NonPortletUtil implements IPortletUtil {

		private static NonPortletUtil INSTANCE;
		
		public static IPortletUtil getInstance() {
			synchronized(NonPortletUtil.class) {
				if (INSTANCE == null) {
					INSTANCE = new NonPortletUtil();
				}
				return INSTANCE;
			}
		}
		
		public final boolean isPortletEnv() {
			return false;
		}

		public final String getPortletNamespace() {
	    	return "";
		}
		
	}
	
	public static IPortletUtil getPortletUtil() {
		if (SpringPortletEnvResolver.isSpringPortletEnv()) {
			return SpringPortletUtil.getInstance();
		} else {
			return NonPortletUtil.getInstance();
		}
	}
}
