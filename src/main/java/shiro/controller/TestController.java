package shiro.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * 会自动导航到templates下的test.html页面
     * templates目录：放置动态页面
     * static目录：放置静态页面
     * @param model
     * @return
     */
    @RequestMapping("/testThemleaf")
    public String testThemleaf(Model model){
        model.addAttribute("name","111");
        return "test";
    }

}
