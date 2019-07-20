package com.server.reko.controller;


import com.server.reko.model.FriendRequest;
import com.server.reko.repository.FriendRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
/**
 * 响应路径例如：localhost:8080/api/userbase
 */
@RequestMapping("/api")
public class FriendRequestController {
    @Autowired
    FriendRequestRepository friendRequestRepository;
    //获取全部好友请求信息
    @GetMapping("/friend_request")
    public List<FriendRequest> getAllFriendRequest(){
        return friendRequestRepository.findAll();
    }
    //获取发送者的好友请求
    @GetMapping("/friend_request/sender/{sender}")
    public List<FriendRequest> getFriendRequestBySenderNumber(@PathVariable(value = "sender") Long sender){
        if(friendRequestRepository.getFriendRequestBySendApplication(sender)!=null)
        {
            return friendRequestRepository.getFriendRequestBySendApplication(sender);
        }
        return null;
    }
    //获取接收者的好友请求
    @GetMapping("/friend_request/geter/{geter}")
    public List<FriendRequest> getFriendRequestByGeterNumber(@PathVariable(value = "geter") Long geter) {
        if (friendRequestRepository.getFriendRequestByGetApplication(geter) != null){
            return friendRequestRepository.getFriendRequestByGetApplication(geter);
        }
        return null;
    }
    //创建好友申请
    @PostMapping("/friend_request")
    public FriendRequest createFriendRequest(@Valid @RequestBody FriendRequest friendRequest)
    {
        if(friendRequestRepository.getFriendRequestBySendApplicationAndGetApplication(friendRequest.getSendApplication(),friendRequest.getGetApplication())==null
        && !friendRequest.getSendApplication().equals(friendRequest.getGetApplication()))
        {
            return friendRequestRepository.save(friendRequest);
        }
        return null;
    }
    //更新好友申请
    @PutMapping("/friend_request")
    public FriendRequest updataFriendRequest(@Valid @RequestBody FriendRequest friendRequest)
    {
        if(friendRequestRepository.getFriendRequestBySendApplicationAndGetApplication(friendRequest.getSendApplication(),friendRequest.getGetApplication())!=null
                && !friendRequest.getSendApplication().equals(friendRequest.getGetApplication())) {
            FriendRequest friendRequest1 = new FriendRequest(
                    friendRequest.getRequestNumber(),
                    friendRequest.getSendApplication(),
                    friendRequest.getGetApplication(),
                    friendRequest.getState());
            return friendRequestRepository.save(friendRequest1);
        }
        return null;
    }
    //删除好友请求
    @DeleteMapping("/friend_request/{sender},{geter}")
    public  Boolean deleteFriendRequest(@PathVariable(value = "sender") Long sender,@PathVariable(value = "geter") Long geter){
        if(friendRequestRepository.getFriendRequestBySendApplicationAndGetApplication(sender,geter)!=null)
        {
            friendRequestRepository.delete(friendRequestRepository.getFriendRequestBySendApplicationAndGetApplication(sender,geter));
            return true;
        }
        return false;
    }
}
