package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class WeatherController extends Controller
	{
		public Result getWeather ( ){return ok ( views.html.weather.render ( ) );}
		
	}
