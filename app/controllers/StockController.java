package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class StockController extends Controller
	{
		public Result getStocks ( ) {return ok ( views.html.stocks.render ( ) );}
		
	}
