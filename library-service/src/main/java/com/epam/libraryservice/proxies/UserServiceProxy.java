package com.epam.libraryservice.proxies;

import com.epam.libraryservice.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service-app")
public interface UserServiceProxy {
    @GetMapping("api/v1/users")
    List<UserInfo> allUsers(@RequestHeader(value = "Authorization", required = true) final String accessToken);

    @GetMapping("api/v1/users/{user_id}")
    UserInfo getUser(@RequestHeader(value = "Authorization", required = true) final String accessToken,
                     @PathVariable(value = "user_id") final int userId);

    @DeleteMapping("api/v1/users/{user_id}")
    String deleteUser(@RequestHeader(value = "Authorization", required = true) final String accessToken,
                      @PathVariable(value = "user_id") final int userId);

    @PostMapping("api/v1/users")
    UserInfo addUser(@RequestHeader(value = "Authorization", required = true) final String accessToken,
                     @RequestBody final UserInfo user);

    @PutMapping("api/v1/users/{user_id}")
    UserInfo updateUser(@RequestHeader(value = "Authorization", required = true) final String accessToken,
                        @PathVariable(value = "user_id") final int userId, @RequestBody UserInfo user);
}
