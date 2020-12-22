package com.wflybook;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class HomeController {

	private final java.util.logging.Logger log = java.util.logging.Logger.getLogger(this.getClass().getName());

	private final Result result;
	
	public HomeController(Result result){
		this.result = result;
	}
	
	@Path("/home")
	public void home() {
		log.severe("This is a fatal message, a high level message error.");
		log.warning("This is a warning message.");
		log.info("This is a information message.");
		log.fine("This is a debug message.");
		log.finest("This is a trace message, very detailed messages.");
	}
}