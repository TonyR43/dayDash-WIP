package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class CalendarController extends Controller
	{
		public Result getCalendar ( ) {return ok ( views.html.calendar.render ( ) );}
		
	}
