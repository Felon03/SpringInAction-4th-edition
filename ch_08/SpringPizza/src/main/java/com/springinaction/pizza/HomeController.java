package com.springinaction.pizza;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-25 15:31
 * Description:
 */

@Controller
public class HomeController {

    @RequestMapping("/")
    public String redirectToFlow() {
        return "redirect:/pizza";
    }
}
