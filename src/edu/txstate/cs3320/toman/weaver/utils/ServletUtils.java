package edu.txstate.cs3320.toman.weaver.utils;

import javax.servlet.ServletConfig;

public class ServletUtils {
	
	private final static String PROJECT_NAME         = "CyberFlix0";
	private final static String MOVIE_DETAIL_SERVLET = "CyberFlixMovieDetailServlet";
	
	private final static String LOCAL_HOST           = "http://localhost:8080/";
	private final static String PROJECT_FILES        =  PROJECT_NAME + "/WebContent/inputFiles";
    private       static String serverFilesPath      = null;
    
    
    public static String getAbsolutePath () {
    	return serverFilesPath;
    }
    
    public static String getLocalHost () {
    	return LOCAL_HOST;
    }
    
    public static String getDetailLinkTargetString () {
    	return LOCAL_HOST + PROJECT_NAME + "/" + 
    			MOVIE_DETAIL_SERVLET + "?film_id=";
    }
    
    public static String getDetailServlet () {
    	return MOVIE_DETAIL_SERVLET;
    }
    
    public static String getProjectInputFilesPath () {
    	String absolutePath = getAbsolutePath();
    	return absolutePath + "/" + PROJECT_FILES;
    }
    
    public static String getProjectName () {
    	return PROJECT_NAME;
    }
    
    /**
     * This method must be called by the "home" servlet (the first one loaded)
     * to set up the file paths for this application. File paths will differ 
     * depending on where the server is running, so to find the location of
     * data files, need to determine the absolute path for this application
     * @param config the configuration for the "home" servlet
     */
    public static void setAbsolutePath (ServletConfig config) {
		String realPathWebInf = config.getServletContext().getRealPath("/WEB-INF");
		int pluginLocation    = realPathWebInf.indexOf(".");
		serverFilesPath       = realPathWebInf.substring(0, pluginLocation);
		System.out.println("ServletDefinitions.setAbsolutePathDirectory: " + serverFilesPath);
    }
 
}
