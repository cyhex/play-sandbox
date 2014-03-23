package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.mvc.*;
import services.MyService;

import java.util.Objects;

public class JsonController extends Controller {


    public static Result index(){
        ObjectNode result = Json.newObject();
        result.put("ok","its ok");

        return ok(result);
    }
}
