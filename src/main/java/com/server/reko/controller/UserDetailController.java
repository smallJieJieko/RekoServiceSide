package com.server.reko.controller;

import com.server.reko.Service.ImageService;
import com.server.reko.model.UserDetail;
import com.server.reko.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;



@RestController
/**
 * 响应路径例如：localhost:8080/api/userbase
 */
@RequestMapping("/api")
public class UserDetailController {

    @Autowired
    UserDetailRepository userDetailRepository;
    @Autowired
    ImageService productServiceImp;

    private ImageService productImageServiceImp;

    //查找全部用户信息
    @GetMapping("/userdetail")
    public List<UserDetail> getAllUserDetail() {
        return userDetailRepository.findAll();
    }

    //创建新的用户详情信息
    @PostMapping("/userdetail")
    public UserDetail createUserDetail(@Valid @RequestBody UserDetail userDetail) {
        if (userDetailRepository.findUserDetailByuDnumber(userDetail.getuDnumber()) == null) {
            return userDetailRepository.save(userDetail);
        }
        return null;
    }

    //查找一个用户详情
    @GetMapping("/userdetail/{udnumber}")
    public UserDetail getUserDetailByuDnumber(@PathVariable(value = "udnumber") Long udnumber) {
        return userDetailRepository.findById(udnumber).get();
    }

    //更新一个用户详情
    @PutMapping("/userdetail/")
    public Boolean updataUserDetail(@Valid @RequestBody UserDetail userDetail) {
        if (userDetailRepository.findUserDetailByuDnumber(userDetail.getuDnumber()) != null) {
            UserDetail userDetail1 = new UserDetail(
                    userDetail.getuDnumber(),
                    userDetail.getBirthday(),
                    userDetail.getSex(),
                    userDetail.getNickName(),
                    userDetail.getPortrait(),
                    userDetail.getCreateANumber(),
                    userDetail.getJoinANubmber(),
                    userDetail.getJoinActivity(),
                    userDetail.getAttentionANumber());
            userDetailRepository.save(userDetail1);
            return true;
        }
        return false;
    }

    //删除一个用户的详情
    @DeleteMapping("/userdetail/{udnumber}")
    public Boolean deleteUserDetail(@PathVariable(value = "udnumber") Long udnumber) {
        if (userDetailRepository.findUserDetailByuDnumber(udnumber) != null) {
            UserDetail userDetail = userDetailRepository.findUserDetailByuDnumber(udnumber);
            userDetailRepository.delete(userDetail);
            return true;
        }
        return false;
    }

    //上传图片
    @RequestMapping(value = "/userdetail/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public Map uploadImg(@RequestParam(value = "file",required = false) MultipartFile file){
        return productServiceImp.uploadImg(file);
    }
}

