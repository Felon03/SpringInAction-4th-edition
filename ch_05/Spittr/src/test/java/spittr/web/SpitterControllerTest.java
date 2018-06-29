package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-06-13 20:35
 * Description:
 */
public class SpitterControllerTest {

    // 测试展现表单的控制器方法
    @Test
    public void shouldShowRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);
        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();  // 构建MockMvc

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));    // 断言registerForm视图
    }

    // 测试处理表单的控制器方法
    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository mockRepository = mock(SpitterRepository.class);   // 构建Repository
        Spitter unsaved = new Spitter("jbauer", "24hours",
                "Jack", "Bauer", "jbauer@ctu.gov");

        Spitter saved = new Spitter(24L, "jbauer", "24hours",
                "Jack", "Bauer", "jbauer@ctu.gov");

        SpitterController controller = new SpitterController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();  // 构建MockMvc

        mockMvc.perform(post("/spitter/register")   // 执行请求
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours")
                .param("email", "jbauer@ctu.gov"));

        verify(mockRepository, atLeastOnce()).save(unsaved);    // 校验保存情况
    }
}
