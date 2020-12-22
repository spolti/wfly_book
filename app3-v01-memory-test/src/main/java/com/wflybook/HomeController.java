package com.wflybook;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class HomeController {

	private final java.util.logging.Logger log = java.util.logging.Logger.getLogger(this.getClass().getName());
	private final Result result;

	public HomeController(Result result) {
		this.result = result;
	}

	@Path("/home")
	public void home(String level) {

		log.info("This app will simulate a OutOfMemory Error.");

		List<Object> list = new ArrayList<Object>();
		
		while (true) {

			try{
				log.info("This is a infinete loop, list size: " + list.size());
				list.add(new Object());
				list.add(new Object());	
			}catch (Exception e){
				log.severe("Objects stored on heap before OutOfMemory: " + list.size());
			}
		}
	}
}