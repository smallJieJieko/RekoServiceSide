package com.server.reko.controller;

import com.server.reko.exception.ResourceNotFoundException;
import com.server.reko.model.UserBase;
import com.server.reko.repository.UserBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @RestController注释是Spring @Controller和@ResponseBody注释的组合。
 * 该@Controller注释被用来定义一个控制器和所述@ResponseBody注释被用于指示一个方法的返回值应作为所述请求的响应主体。
 */
@RestController
/**
 * 响应路径例如：localhost:8080/api/userbase
 */
@RequestMapping("/api")
public class UserBaseController {
    @Autowired
    UserBaseRepository userBaseRepository;
    // Get All users
    @GetMapping("/userbase")
    public List<UserBase> getAllUserBase() {
        return userBaseRepository.findAll();
    }
    // 创建新用户
    @PostMapping("/userbase")
    /**
     * @RequestBody注释用于请求体的方法参数绑定
     * @Valid注释可以确保请求主体是有效的
     */
    public Boolean createUserBase(@Valid @RequestBody UserBase userBase) {
        //如果用户名和用户编号都不重复那么创建这个账号
        if(userBaseRepository.findUserBaseByuBnumber(userBase.getuBnumber())==null && userBaseRepository.findUserBaseByAccount(userBase.getAccount())==null){
           userBaseRepository.save(userBase);
           return true;
        }
        return false;
    }
    // Get a Single user
    //通过ubnumber查找
    @GetMapping("/userbase/ubnumber/{ubnumber}")
    /**
     * orElseThrow(()->如果找不到将会调用Exception 抛出404错误
     */
    public Boolean getUserBaseByUBnumber(@PathVariable(value = "ubnumber") Long ubnumber) {
        return userBaseRepository.findById(ubnumber).isPresent();
    }
    //通过account查找
    @GetMapping("/userbase/account/{account}")
    public UserBase getUserBaseByAccount(@PathVariable(value = "account") String account) {

        long roung = -1;
        if(userBaseRepository.findUserBaseByAccount(account)!=null)
        {
            return userBaseRepository.findUserBaseByAccount(account);
        }else {
            return userBaseRepository.findById(roung).orElseThrow(() -> new ResourceNotFoundException("UserBase", "account", account));
        }
    }
    //通过账户密码查找
    @GetMapping("/userbase/check/{account},{password}")
    public Boolean getUserBaseByAccountAndPassword(@PathVariable(value = "account") String account,@PathVariable(value = "password") String password) {
        if(userBaseRepository.findUserBaseByAccount(account)!=null)
        {
            if(userBaseRepository.findUserBaseByAccount(account).getPassWord().equals(password))
            {
                return true;
            }
            return false;
        }else {
            return false;
        }
    }
    // Update a user
    //通过ubnumber查找
    @PutMapping("/userbase/{ubnumber}")
    public UserBase updateNote(@PathVariable(value = "ubnumber") Long ubnumber,
                           @Valid @RequestBody UserBase userBaseDetails) {

        UserBase userBase = userBaseRepository.findById(ubnumber)
                .orElseThrow(() -> new ResourceNotFoundException("UserBase", "ubnumber", ubnumber));

        userBase.setAccount(userBaseDetails.getAccount());
        userBase.setPassWord(userBaseDetails.getPassWord());
        userBase.setuBnumber(userBaseDetails.getuBnumber());
        UserBase updatedUserBase = userBaseRepository.save(userBase);
        return updatedUserBase;
    }
    // Delete a user
    @DeleteMapping("/userbase/{ubnumber}")
    public Boolean deleteNote(@PathVariable(value = "ubnumber") Long ubnumber) {
        if(userBaseRepository.findUserBaseByuBnumber(ubnumber)!=null){
            UserBase userBase=userBaseRepository.findUserBaseByuBnumber(ubnumber);
            userBaseRepository.delete(userBase);
            return true;
        }
        return false;
    }
}
