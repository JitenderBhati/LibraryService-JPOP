package com.epam.user_service.service;

import com.epam.user_service.api.dto.UserDto;
import com.epam.user_service.dao.UserDataAccessService;
import com.epam.user_service.models.User;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserDataAccessService userDataAccessService;
    private final ModelMapper mapper;

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    public UserService(@Qualifier("UserDto") final UserDataAccessService userDataAccessService,
                       final ModelMapper mapper) {
        this.userDataAccessService = userDataAccessService;
        this.mapper = mapper;
    }

    public List<UserDto> getAllUsers() {
        List<User> allUsers = this.userDataAccessService.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        allUsers.forEach(user -> userDtoList.add(this.mapper.map(user, UserDto.class)));
        return userDtoList;
    }

    public UserDto getUser(final Long id) throws IllegalAccessException {
        Optional<User> userData = this.userDataAccessService.findById(id);
        if(userData.isPresent()) {
            return this.mapper.map(userData.get(), UserDto.class);
        }
        throw new IllegalAccessException();
    }

    public UserDto updateUser(final Long id, final UserDto user) {
        User fetchedUser = this.userDataAccessService.getOne(id);
        this.mapper.map(user, fetchedUser);
        return this.mapper.map(this.userDataAccessService.save(fetchedUser), UserDto.class);
    }

    public UserDto addUser(final UserDto user) {
        User mappedUser = this.mapper.map(user, User.class);
        log.error("Mapped User After Mapping: {}", mappedUser);
        User savedUser = this.userDataAccessService.save(mappedUser);
        log.error("Saved User After Saving: {}", savedUser);
        return this.mapper.map(savedUser, UserDto.class);
    }

    public void deleteUser(final Long id) {
        this.userDataAccessService.deleteById(id);
    }
}
