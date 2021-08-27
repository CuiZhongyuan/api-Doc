package com.taltools.controller;


import com.github.pagehelper.PageInfo;
import com.taltools.entity.UserEntity;
import com.taltools.entity.query.UserQuery;
import com.taltools.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@SuppressWarnings("ALL")
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 列表数据的返回，
     * */
    @GetMapping("/")
    public String index(Model model, UserQuery userQuery){
        PageInfo<UserEntity> userPageInfo =userService.listUserByName(userQuery);
        model.addAttribute("page",userPageInfo);
        // editUser对应templates下的index.html页面名
        return "index";
    }
    /**
     * 查询名称列表返回
     * */
    @PostMapping("/")
    public String listUserByName(Model model,UserQuery userQuery){
        PageInfo<UserEntity> userPageInfo = userService.listUserByName(userQuery);
        model.addAttribute("page",userPageInfo);
        return "index";
    }
    /**
     * 删除用户成功重定向到首页
     * @param id
     * 列表id，注解名称与参数名称一致，获取后复制给：@GetMapping("/delete/{id}")id参数
     * @param attributes
     * RedirectAttributes重定向：提示语
     * */
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id, RedirectAttributes attributes){
        boolean b = userService.deleteUserById(id);
        if(b){
            attributes.addFlashAttribute("message","删除用户成功");
            //删除成功重定向到首页
            return "redirect:/";
        }else {
            attributes.addFlashAttribute("message","删除用户失败");
            return "redirect:/";
        }
    }


    @GetMapping("/edit/{id}")
   public String toEdit(@PathVariable Integer id,Model model){
        model.addAttribute("user",userService.queryUserById(id));
        // editUser对应templates下的editUser.html页面名
        return "editUser";
   }


   @PostMapping("/edit")
   public String edit(UserEntity userEntity, RedirectAttributes attributes){
       UserQuery userQuery = new UserQuery();
       Integer id = userEntity.getId();
       userQuery.setName(userEntity.getName());
       PageInfo<UserEntity> userPageInfo = userService.listUserByName(userQuery);
       if(id != null){
           if(userPageInfo.getSize() == 0){
               boolean b = userService.updateUser(userEntity);
               if(b){
                   attributes.addFlashAttribute("message"," 更新用户成功");
                   return "redirect:/";
               }else {
                   attributes.addFlashAttribute("message","更新用户失败");
                   return "redirect:/";
               }
           }else {
               attributes.addFlashAttribute("message","该用户名已存在");
               return "redirect:/edit/"+userEntity.getId();
           }
       }else {
           if(userPageInfo.getSize() == 0){
               boolean b = userService.addUser(userEntity);
               if(b){
                   attributes.addFlashAttribute("message"," 新增用户成功");
                   return "redirect:/";
               }else {
                   attributes.addFlashAttribute("message","新增用户失败");
                   return "redirect:/";
               }
           }else {
               attributes.addFlashAttribute("message","该用户名已存在");
               return "redirect:/";
           }
       }
   }

   @GetMapping("/update")
   public String toUpdate(Model model){
       UserEntity userEntity = new UserEntity();
       model.addAttribute("user",userEntity);
       return "editUser";
   }

}
