package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 20:47
 * Description:
 */

@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private static final String MAX_LONG_AS_STRING = "9223372036854775807";
//    private static final String MAX_LONG_AS_STRING = Long.toString(Long.MAX_VALUE);

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(SpittleRepository spittleRepository) { // 注入SpittleRepository
        this.spittleRepository = spittleRepository;
    }

//    @RequestMapping(method = RequestMethod.GET)
//    public String spittles(Model model) {
//        // 将spittle添加到模型中
//        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//        return "spittles";  // 返回视图名
//    }

    // 在模型中放入最新的spittle列表，支持指定参数的查询
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(
            @RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count", defaultValue = "20") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    // 根据给定ID来展现某一格Spittle记录
//    @RequestMapping(value = "/show", method = RequestMethod.GET)
//    public String showSpittle(
//            @RequestParam("spittle_id") long spittleId, Model model) {
//        model.addAttribute(spittleRepository.findOne(spittleId));
//        return "spittle";
//    }

    // 根据给定ID来展现某一格Spittle记录, 使用占位符，将Spittle ID作为路径的一部分
    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittle(
            @PathVariable("spittleId") long spittleId, Model model) {
//        model.addAttribute(spittleRepository.findOne(spittleId));
        Spittle spittle = spittleRepository.findOne(spittleId);
        if (spittle == null) {
            // 如果spittle不存在，则抛出异常
            throw new SpittleNotFoundException();
        }
        model.addAttribute(spittle);
        return "spittle";
    }

    // 保存新建的Spittle，并检查是否与已有的Spittle重复
    @RequestMapping(method = RequestMethod.POST)
    public String saveSpittle(SpittleForm form, Model model) {
        spittleRepository.save(new Spittle(null, form.getMessage(), new Date(),
                form.getLongitude(), form.getLatitude()));
        return "redirect:/spittles";
    }

//    @ExceptionHandler(DuplicateSpittleException.class)
//    public String handleNotFound() {
//        return "error/duplicate";
//    }
}
