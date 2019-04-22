package controllers;

import play.mvc.Result;

import static play.mvc.Results.ok;

public class ReadMeController
	{
		public Result getReadMe ( ) {return ok ( views.html.readme.render ( ) );}
		
	}
