package controllers;

import play.*;
import play.cache.Cached;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
    public static Result index() {
        flash("success", "yess");
        return ok(index.render("Your new application is ready."));
    }

}
