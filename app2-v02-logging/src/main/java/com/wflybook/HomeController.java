package com.wflybook;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class HomeController {

	private final Result result;

	
	public HomeController(Result result){
		this.result = result;
	}
	
	@Path("/home")
	public void home(String level) {
				
		
		Logger.getLogger(getClass()).fatal("This is a fatal message, a high level message error.");
		Logger.getLogger(getClass()).error("This is a error message.");
		Logger.getLogger(getClass()).warn("This is a warning message.");
		Logger.getLogger(getClass()).info("This is a information message.");
		Logger.getLogger(getClass()).debug("This is a debug message.");
		Logger.getLogger(getClass()).trace("This is a trace message, very detailed messages.");
		
		
		result.include("oi","oi");
		
	}
}