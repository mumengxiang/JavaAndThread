package shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /**
     * 会自动导航到templates下的test.html页面
     * templates目录：放置动态页面
     * static目录：放置静态页面
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public String testThemleaf(Model model){
        model.addAttribute("name","主页");
        return "index";
    }

    /**
     * 用户新增
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "/user/add";
    }

    /**
     * 用户修改
     * @return
     */
    @RequestMapping("/update")
    public String update(){
        return "/user/update";
    }

    /**
     * 用户登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    /**
     * 设置未授权的页面
     * @return
     */
    @RequestMapping("/unAuth")
    public String unAuth(){
        return "unAuth";
    }



    /**
     * 用户登录操作
     * @return
     */
    @RequestMapping("/login")
    public String login(String name, String pwd, Model model) {
        /**
         * 根据shiro进行用户验证
         */
        //1.获取Subject
        final Subject subject = SecurityUtils.getSubject();

        //2.封装用户数据
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name, pwd);

        //3.执行登录方法
        try {
            //如果没有异常 则表示登录成功
            //此处登录方法会进入到UserRealm的doGetAuthenticationInfo方法中
            subject.login(usernamePasswordToken);
            //跳转到首页
            return "redirect:/index";
        }catch (UnknownAccountException e){
            //登录失败:用户名不存在
            model.addAttribute("msg","用户名不存在");
            //返回登录页
            return "login";
        }catch (IncorrectCredentialsException e){
            //登录失败:密码错误
            model.addAttribute("msg","密码错误");
            //返回登录页
            return "login";
        }

    }

}
