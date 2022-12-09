package com.tear.sys.controller;

import com.github.pagehelper.PageInfo;
import com.tear.sys.entity.Admin;
import com.tear.sys.entity.User;
import com.tear.sys.entity.thing;
import com.tear.sys.service.AdminService;
import com.tear.sys.service.UserService;
import com.tear.sys.service.thingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AdminService adminService;

    @Autowired
    thingService thingService;

    @RequestMapping("/GoADminLoign")
    public String  ToADminG(){
        return  "admin/adminLogin";
    }
@RequestMapping("/adminLogin")
public String  GoAdminLogin(@RequestParam String cname,
                            @RequestParam String cpwd,
                            HttpSession session,
                            RedirectAttributes attributes
){

        //设置Session  用于拦截非登录访问
  Admin admin= adminService.CheckAdmin(cname,cpwd  );
  if (admin==null){
      attributes.addFlashAttribute("message","用户名或密码错误");
      return "admin/adminLogin";
  }else{
      session.setAttribute("admin",admin);
      session.setMaxInactiveInterval(-1);//设置Session永不过期

      return "redirect:/admin";
  }
}

//TochangeAdminPwd  前往修改后台密码
    @RequestMapping("/TochangeAdminPwd")
    public String  changeADminPWd(Integer aid,Model model){//默认带入参数1
       Admin admin1= adminService.FindOne(aid);
       model.addAttribute("admin1",admin1);
        return  "admin/changePwdForAdmin";
    }
    @RequestMapping("/UpdatAdminPwd")
    public String  updateAdminPwd(Admin admin){
        //返回admin就是后台管理页面
        adminService.update(admin);
        return  "redirect:/admin";
    }

//注销操作
//@GetMapping("/logout")
//public String logout(HttpSession session) {
//    session.removeAttribute("user");
//    return "redirect:/admin";
//}

    @RequestMapping("/admin")
    public String  test(){
        return  "admin/index";
    }

    @RequestMapping("/list")
    public String  listByPage(@RequestParam(defaultValue = "1")Integer pageNum,
                              @RequestParam(defaultValue = "5")Integer pageSize,
                              Model model){
        //接下来是正常的查询操作
        List<User> users=userService.findALlByPa(pageNum,pageSize);
model.addAttribute("users",users);
        PageInfo pageInfo=new PageInfo(users,pageSize);  //导航页面多少页 最大
model.addAttribute("pageInfo",pageInfo);
        return "admin/UserControler";
    }

    @RequestMapping("Edit")
    public String  EditOne(Integer  userId,Model model){
        User userOne=userService.findUserById(userId);
        model.addAttribute("userOne",userOne);
        return  "admin/edit";
    }
    @RequestMapping("/update")
    public String   updateOne(User user){
        //Spring data jpa 的一个小问题 前端必须在Input传输标签使用th:value才可使用save进行更新操作
        userService.update(user);
        return "redirect:/list";
    }

    @RequestMapping("add")
    public String  addOne(User user){
        //添加用户则使用 th:text文本显示
        userService.add(user);
        return "redirect:/list";
    }

    @RequestMapping("register")
    public String  RegisterUser(User user){
        //添加用户则使用 th:text文本显示
        userService.add(user);
        return "former/login";
    }
    @RequestMapping("/ToRegister")
    public String   Toregister(){
        return "former/register";
    }

    @RequestMapping("/ToAdd")
    public String  TOadd(){
        return "admin/addUser";
    }

    @RequestMapping("Delete")
    public String  DeleteOne(Integer userId){
        userService.delete(userId);
        //删除成功
        return "redirect:/list";
    }
    @RequestMapping("ToLogin")
    public String  toG(){
        return  "former/login";
    }
    @RequestMapping("login")
    public String   userLogin(String username,String  password,Model model){
      User us=userService.login(username,password);
    //逻辑是没有问题的,注意细心观察代码,数据库密码都对不上怎么登录成功。
        //顺带传入商品参数@
        List<thing> things=thingService.findAll();
        model.addAttribute("things",things);//传入部分商品
        if(us==null){
            return "former/login";
        }

            return "former/index";

    }

    //直接进入首
    @RequestMapping("/IndexForMe")
    public String  PUblicIndex(Model model){
        List<thing> things=thingService.findAll();
        model.addAttribute("things",things);
        return "former/index";
    }


    //进入商品管理链接
//    @RequestMapping("/StoreManage")
//    public String managerStore(){
//        return  "admin/storeIndex";
//    }



}
