package com.server.reko.controller;

import com.server.reko.model.UserFriends;
import com.server.reko.repository.UserFriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
/**
 * 响应路径例如：localhost:8080/api/userbase
 */
@RequestMapping("/api")
public class UserFriendsController {
    @Autowired
    UserFriendsRepository userFriendsRepository;
    //查找全部好友信息
    @GetMapping("/userfriends")
    public List<UserFriends> getAllUserFriends(){
        return userFriendsRepository.findAll();
    }
    //根据用户编号查找好友信息
    @GetMapping("/userfriends/{ubnumber}")
    public List<UserFriends> getUserFriendsByUBnumber(@PathVariable(value = "ubnumber")Long ubnumber){
        if(userFriendsRepository.findUserFriendsByUBnumber(ubnumber)!=null)
        {
            return  userFriendsRepository.findUserFriendsByUBnumber(ubnumber);
        }
        return null;
    }
    //新建用户好友信息
    @PostMapping("/userfriends")
    public UserFriends createFriends(@Valid @RequestBody UserFriends userFriends){
        if(userFriendsRepository.findUserFriendsByUBnumberAndAndUFnumber(userFriends.getuBnumber(), userFriends.getuFnumber())==null
        && !userFriends.getuBnumber().equals(userFriends.getuFnumber()))
        {
            return userFriendsRepository.save(userFriends);
        }
        return null;
    }
    //删除用户好友信息
    @DeleteMapping("/userfriends/{ubnumber},{ufnumber}")
    public Boolean deleteFriends(@PathVariable(value = "ubnumber")Long ubnumber,@PathVariable(value = "ufnumber")Long ufnumber) {
        if(userFriendsRepository.findUserFriendsByUBnumberAndAndUFnumber(ubnumber,ufnumber)!=null)
        {
            userFriendsRepository.delete(userFriendsRepository.findUserFriendsByUBnumberAndAndUFnumber(ubnumber,ufnumber));
            return true;
        }
        return false;
    }
}


