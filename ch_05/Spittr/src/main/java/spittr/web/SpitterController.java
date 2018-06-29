package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-13 20:18
 * Description:
 */

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    // 展现一个表单并注册新用户
    @RequestMapping(value = "/register", method = GET)  // 处理对"/spitter/register"的请求
    public String showRegistrationForm() {
        return "registerForm";
    }

    // 处理所提交的表单并注册新用户
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid Spitter spitter, Errors errors) {  // 校验Spitter输入
        if (errors.hasErrors()) {
            return "registerForm";  // 如果校验出错，则重新返回表单
        }
        spitterRepository.save(spitter);    // 保存Spitter

        return "redirect:/spitter/" + spitter.getUsername();    // 重定向到基本信息页
    }

    // 处理对基本信息页面的请求
    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUserName(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
