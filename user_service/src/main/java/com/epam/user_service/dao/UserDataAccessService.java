package com.epam.user_service.dao;

import com.epam.user_service.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserDto")
public interface UserDataAccessService extends JpaRepository<User, Long> {
}
