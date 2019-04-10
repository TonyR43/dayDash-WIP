package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class VoiceController extends Controller
	{
		public Result getRecord ( ){return ok ( views.html.recordmain.render ( ) );}
	}
