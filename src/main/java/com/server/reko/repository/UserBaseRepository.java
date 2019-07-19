package com.server.reko.repository;

import com.server.reko.model.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * 告诉Spring在组件扫描期间引导存储库
 */
@Repository
/**
 * 实体和主键类型
 * extends JpaRepository<UserBase,Long>
 * 能够使用JpaRepository的方法，如save()，findOne()，findAll()，count()，delete()等。
 *
 */
public interface UserBaseRepository extends JpaRepository<UserBase,Long> {
    UserBase findUserBaseByAccount(String account);
    UserBase findUserBaseByuBnumber(Long uBnumber);
}
