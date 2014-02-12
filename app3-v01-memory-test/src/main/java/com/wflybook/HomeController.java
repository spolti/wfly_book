package com.wflybook;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class HomeController {

	private final Result result;

	public HomeController(Result result) {
		this.result = result;
	}

	@Path("/home")
	public void home(String level) {

		Logger.getLogger(getClass()).info(
				"This app will simulate a OutOfMemory Error.");

		List<Object> list = new ArrayList<Object>();

		while (true) {

			Logger.getLogger(getClass()).info("This is a infinete loop, list size: " + list.size());
			list.add(new Object());
			list.add(new Object());

		}
	}
}