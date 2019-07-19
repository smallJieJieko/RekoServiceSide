package com.server.reko.controller;


import com.server.reko.model.UserPermission;
import com.server.reko.repository.UserBaseRepository;
import com.server.reko.repository.UserPermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
/**
 * 响应路径例如：localhost:8080/api/userbase
 */
@RequestMapping("/api")
public class UserPermissionController {
    @Autowired
    UserPermissionRepository userPermissionRepository;
    UserBaseRepository userBaseRepository;
    //查询全部用户限权信息
    @GetMapping("/userPermission")
    public List<UserPermission> getAllUserPermission(){
        return userPermissionRepository.findAll();
    }
    //创建新的用户限权信息
    @PostMapping("/userPermission")
    public UserPermission createUserPermission(@Valid @RequestBody UserPermission userPermission){
        if(userPermissionRepository.findUserPermissionByuPnumber(userPermission.getuPnumber())==null){
            return userPermissionRepository.save(userPermission);
        }
        return null;
    }
    //查找一个用户的权限信息
    @GetMapping("/userPermission/{upnumber}")
    public UserPermission getUserPermission(@PathVariable(value = "upnumber") Long upnumber){
        return userPermissionRepository.findById(upnumber).get();
    }
    //更新一个用户的权限信息
    @PutMapping("/userPermission")
    public UserPermission updataUserPermission(@Valid @RequestBody UserPermission userPermission){
        if(userPermissionRepository.findUserPermissionByuPnumber(userPermission.getuPnumber())!=null) {
            UserPermission userPermission1 = new UserPermission(
                    userPermission.getuPnumber(),
                    userPermission.getChangeDetail(),
                    userPermission.getCreateActivity(),
                    userPermission.getLookActivity(),
                    userPermission.getChangeActivity(),
                    userPermission.getDeleteAchitity(),
                    userPermission.getAddFriends(),
                    userPermission.getLookFriends(),
                    userPermission.getDeleteFriends(),
                    userPermission.getSetAdministrator(),
                    userPermission.getDeleteUser());
            return userPermissionRepository.save(userPermission1);
        }
        return null;
    }
    //删除一个用户的权限信息
    @DeleteMapping("/userPermission/{upnumber}")
    public Boolean deleteUserPermission(@PathVariable(value = "upnumber") Long upnumber){
        if(userPermissionRepository.findUserPermissionByuPnumber(upnumber)!=null){
            UserPermission userPermission =userPermissionRepository.findUserPermissionByuPnumber(upnumber);
            userPermissionRepository.delete(userPermission);
            return true;
        }
        return false;
    }
}
