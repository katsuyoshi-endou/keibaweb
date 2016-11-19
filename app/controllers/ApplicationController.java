package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class ApplicationController extends Controller {
	public Result showKeibaweb() {
		return ok(keibaweb.render(null));
	}
}
