package com.server.reko.controller;

import com.server.reko.Service.ImageService;
import com.server.reko.model.RekoActivity;
import com.server.reko.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ActivityController {
    @Autowired


    ActivityRepository activityRepository;
    @Autowired
    ImageService productServiceImp;
    //查找全部
    @GetMapping("/activity")
    public List<RekoActivity> getAllActivitys(){
        return  activityRepository.findAll();
    }
    //通过活动编号查找活动
    @GetMapping("/activity/anumber/{anumber}")
    public RekoActivity getActivityByaNumber(@PathVariable(value = "anumber")Long anumber){
        return activityRepository.findActivitiesByaNumber(anumber);
    }
    //通过创建者查找活动
    @GetMapping("/activity/createrNumber/{createrNumber}")
    public List<RekoActivity> getActivitysByCreaterNumber(@PathVariable(value = "createrNumber")Long createrNumber){
        if(activityRepository.findActivitiesByCreaterNumber(createrNumber)!=null){
            return activityRepository.findActivitiesByCreaterNumber(createrNumber);
        }
        return null;
    }
    //创建活动
    @PostMapping("/activity")
    public RekoActivity createActivity(@Valid @RequestBody RekoActivity rekoActivity){
        if(activityRepository.findActivitiesByaNumber(rekoActivity.getaNumber())==null){
            return activityRepository.save(rekoActivity);
        }
        return null;
    }

    //更新活动
    @PutMapping("/activity")
    public RekoActivity updataActivity(@Valid @RequestBody RekoActivity rekoActivity){
        if(activityRepository.findActivitiesByaNumber(rekoActivity.getaNumber())!=null){
            RekoActivity rekoActivity1 = new RekoActivity(
                    rekoActivity.getaNumber(),
                    rekoActivity.getCreaterNumber(),
                    rekoActivity.getaName(),
                    rekoActivity.getLabel1Type(),
                    rekoActivity.getLabel2Site(),
                    rekoActivity.getPhotograph(),
                    rekoActivity.getContentType(),
                    rekoActivity.getHeadcount(),
                    rekoActivity.getActivityState(),
                    rekoActivity.getIntro(),
                    rekoActivity.getDetail(),
                    rekoActivity.getMemberNumber(),
                    rekoActivity.getStartTime(),
                    rekoActivity.getFinishTime()
            );
            return activityRepository.save(rekoActivity1);
        }
        return null;
    }
    //删除活动
    @DeleteMapping("/activity/{anumber}")
    public Boolean deleteActivity(@PathVariable(value = "anumber")Long anumber){
        if(activityRepository.findActivitiesByaNumber(anumber)!=null)
        {
            RekoActivity rekoActivity= activityRepository.findActivitiesByaNumber(anumber);
            activityRepository.delete(rekoActivity);
            return true;
        }
        return false;
    }
    //上传图片
    @RequestMapping(value = "/activity/uploadImg",method = RequestMethod.POST)
    @ResponseBody
    public Map uploadImg(@RequestParam(value = "file",required = false) MultipartFile file){
        return productServiceImp.uploadImg(file);
    }
}
