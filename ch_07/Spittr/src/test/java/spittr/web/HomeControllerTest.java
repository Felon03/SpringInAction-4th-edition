package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-12 20:09
 * Description: 测试HomeController，使用Spring MVC中新的测试特性
 */
public class HomeControllerTest {

    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();  // 搭建MockMVC
        mockMvc.perform(get("/"))
                .andExpect(view().name("home"));    // 对"/"执行GET请求，预期得到home视图
        mockMvc.perform(get("/homepage"))
                .andExpect(view().name("home"));    // 对"/homepage"执行GET请求，预期得到home视图
    }
}
