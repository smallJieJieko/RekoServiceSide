package com.server.reko.repository;

import com.server.reko.model.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepository extends JpaRepository<UserPermission,Long> {
     UserPermission findUserPermissionByuPnumber(Long uPnumber);
}
