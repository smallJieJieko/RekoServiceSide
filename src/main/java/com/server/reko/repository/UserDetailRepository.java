package com.server.reko.repository;

import com.server.reko.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
    UserDetail findUserDetailByuDnumber(Long uDnumber);
}
