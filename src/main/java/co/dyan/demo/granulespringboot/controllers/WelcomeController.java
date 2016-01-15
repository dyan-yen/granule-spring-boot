package co.dyan.demo.granulespringboot.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Map;

/**
 * Created by dyan on 1/14/16.
 */

@Controller
public class WelcomeController {

    @Value("${application.message}")
    private String message = "";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("message", message);
        return "welcome";
    }
}
