package controllers;

import com.google.inject.Inject;
import play.mvc.Controller;
import play.mvc.Result;
import services.MyService;

public class DiController extends Controller {

    @Inject MyService myservice;

    public Result test(){
        myservice.setSay("say hello");
        return ok(myservice.getSay());
    }

    public Result test2(){
        return ok(myservice.getSay());
    }

}
