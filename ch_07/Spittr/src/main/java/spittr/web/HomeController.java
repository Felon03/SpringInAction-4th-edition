package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 19:52
 * Description: 超级简单的控制器
 */

@Controller     // 声明为一个控制器
@RequestMapping({"/", "/homepage"})    // 将控制器映射到"/"和"/homepage"
public class HomeController {

    @RequestMapping(method = GET)   // 处理GET请求
    public String home(Model model) {
        return "home";  // 视图名为home
    }
}
