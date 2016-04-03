package com.grijesh.velocity.demo;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by grijesh on 4/4/16.
 */
public class HelloWorld {

    public static void main(String ar[]) {
         /*  first, get and initialize an engine  */
        Properties velocityProperties = new Properties();
        velocityProperties.setProperty("file.resource.loader.path",
                "/home/grijesh/java-playground/velocity-template/src/main/resources");

        // Use this properties to initialize the engine
        VelocityEngine ve = new VelocityEngine();
        ve.init(velocityProperties);
        ve.init();
        /*  next, get the Template  */
        Template t = ve.getTemplate("helloworld.json");
        /*  create a context and add data */
        VelocityContext context = new VelocityContext();
        Map<String,Object> names = new HashMap<>();
        names.put("firstName","Grijesh");
        names.put("secondName",null);
        context.put("names", names);
        /* now render the template into a StringWriter */
        StringWriter writer = new StringWriter();
        t.merge(context, writer);
        /* show the World */
        System.out.println(writer.toString());
    }
}
