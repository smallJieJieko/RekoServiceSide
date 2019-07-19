package com.server.reko.repository;

import com.server.reko.model.FriendRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRequestRepository extends JpaRepository<FriendRequest,Long> {

    List<FriendRequest> getFriendRequestBySendApplication(Long senderNumber);
    List<FriendRequest> getFriendRequestByGetApplication(Long geterNumber);
    FriendRequest getFriendRequestBySendApplicationAndGetApplication(Long senderNumber,Long geterNumber);
}
