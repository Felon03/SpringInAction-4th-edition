package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.validation.Valid;

import java.io.File;
import java.io.IOException;

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
//    @RequestMapping(value = "/register", method = GET)  // 处理对"/spitter/register"的请求
//    public String showRegistrationForm() {
//        return "registerForm";
//    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new SpitterForm());
        return "registerForm";
    }

    // 处理所提交的表单并注册新用户
//    @RequestMapping(value = "/register", method = POST)
//    public String processRegistration(@Valid Spitter spitter, Errors errors) {  // 校验Spitter输入
//        if (errors.hasErrors()) {
//            return "registerForm";  // 如果校验出错，则重新返回表单
//        }
//        spitterRepository.save(spitter);    // 保存Spitter
//
//        return "redirect:/spitter/" + spitter.getUsername();    // 重定向到基本信息页
//    }

    // 通过URL模板进行重定向
//    @RequestMapping(value = "/register", method = POST)
//    public String processRegistration(Spitter spitter, Model model) {
//        spitterRepository.save(spitter);
//
//        // 以username作为占位符填充到URL模板中
//        model.addAttribute("username", spitter.getUsername());
//        return "redirect:/spitter/{username}";
//
//        // 将username和id添加到URL中作为查询参数
//        model.addAttribute("username", spitter.getUsername());
//        model.addAttribute("spitterId", spitter.getId());
//        return "redirect:/spitter/{username}";
//    }

    // 使用flash属性，使对象在重定向的过程中存活下来
//    @RequestMapping(value = "/register", method = POST)
//    public String processRegistration(Spitter spitter, RedirectAttributes model) {
//        spitterRepository.save(spitter);
//        model.addAttribute("username", spitter.getUsername());
//        // 将key设为spitter
//        model.addFlashAttribute("spitter", spitter);
//        // 也可以不设置key，让key根据值的类型自行推断得出
//        model.addAttribute(spitter);
//        return "redirect:/spitter/{username}";
//    }

    // 处理所提交的表单并注册新用户
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(
            @Valid SpitterForm spitterForm, Errors errors) throws IllegalStateException, IOException {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        // 接受MultipartFile，并通过其接口方法将文件写入到文件系统中
        MultipartFile profilePicture = spitterForm.getProfilePicture();
        String pathname = "D:\\IdeaProjects\\spinginaction\\ch_09\\thymeleaf\\src\\main\\webapp\\tmp\\spittr";
        profilePicture.transferTo(new File(pathname + spitter.getUsername() + ".jpg"));
        return "redirect:/spitter/" + spitter.getUsername();
    }

    // 处理对基本信息页面的请求
//    @RequestMapping(value = "/{username}", method = GET)
//    public String showSpitterProfile(
//            @PathVariable String username, Model model) {
//        Spitter spitter = spitterRepository.findByUserName(username);
//        model.addAttribute(spitter);
//        return "profile";
//    }

    // 处理基本信息页面的请求
    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            model.addAttribute(spitterRepository.findByUserName(username));
        }
        return "profile";
    }
}
