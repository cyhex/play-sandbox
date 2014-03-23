package controllers;

import akka.io.Tcp;
import play.i18n.Messages;
import play.mvc.Result;

import java.lang.reflect.InvocationTargetException;

import static play.mvc.Results.*;

/**
 * Created by gx on 22/03/14.
 */
public class DynamicController {

    public static Result dispatch(String action){
        try {
            Result r = (Result) DynamicController.class.getMethod(action).invoke(null);
            return r;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return badRequest(Messages.get("cant.find.action"));
    }

    public static Result test(){
        String m = Messages.get("some.other.mssaege");
        return ok(Messages.get("test.hello", "sucker"));
    }


}
