package controllers;

import lib.cache.CachedResult;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

public class Application extends Controller {

    @CachedResult(key="test")
    public static Result index() {
        flash("success", "yess");
        return ok(index.render("Your new application is ready."));
    }

}
