package br.com.tomasmuller.neo4jtemplate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class WelcomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "welcome/index";
  }

}
