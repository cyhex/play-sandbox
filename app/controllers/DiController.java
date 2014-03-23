package controllers;

import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import services.CachedSession;
import services.MyService;

public class DiController extends Controller {

    @Inject MyService myservice;
    @Inject CachedSession userSession;

    public Result test(){
        myservice.setSay("say hello");
        userSession.set("x", "user bound session");
        return ok(myservice.getSay());
    }

    public Result test2(){
        return ok((String) userSession.get("x", " not found"));
    }

}
