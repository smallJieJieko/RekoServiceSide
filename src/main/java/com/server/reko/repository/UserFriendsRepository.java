package com.server.reko.repository;

import com.server.reko.model.UserFriends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFriendsRepository extends JpaRepository<UserFriends,Long> {
    List<UserFriends> findUserFriendsByUBnumber(Long uBnumber);
    UserFriends findUserFriendsByUBnumberAndAndUFnumber(Long uBnumber,Long uFnumber);
}
