package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.keibaweb;

public class ApplicationController extends Controller {
	public Result showKeibaweb() {
		return ok(keibaweb.render(null));
	}
}
