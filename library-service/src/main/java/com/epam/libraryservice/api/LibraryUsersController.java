package com.epam.libraryservice.api;

import com.epam.libraryservice.pojo.Library;
import com.epam.libraryservice.pojo.LibraryInfo;
import com.epam.libraryservice.pojo.UserInfo;
import com.epam.libraryservice.provider.TokenProvider;
import com.epam.libraryservice.proxies.BookServiceProxy;
import com.epam.libraryservice.proxies.UserServiceProxy;
import com.epam.libraryservice.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/library/users")
public class LibraryUsersController {
    private final UserServiceProxy userServiceProxy;
    private final BookServiceProxy bookServiceProxy;
    private final LibraryService libraryService;
    private final LibraryInfo libraryInfo;

    @Autowired
    public LibraryUsersController(final UserServiceProxy userServiceProxy,
                                  final BookServiceProxy bookServiceProxy,
                                  final LibraryService libraryService,
                                  final LibraryInfo libraryInfo) {
        this.userServiceProxy = userServiceProxy;
        this.bookServiceProxy = bookServiceProxy;
        this.libraryService = libraryService;
        this.libraryInfo = libraryInfo;
    }

    @GetMapping("{user_id}")
    public ResponseEntity<List<LibraryInfo>> getUser(@PathVariable(value = "user_id") final int user_id) {
        List<Library> libraryData = this.libraryService.getUserBooks(user_id);
        List<LibraryInfo> allLibraryInfo = new ArrayList<>();
        libraryData.forEach(lib -> {
            libraryInfo.setUserInfo(userServiceProxy.getUser(TokenProvider.getAccessToken(), lib.getUser()));
            libraryInfo.setBook(bookServiceProxy.getBook(TokenProvider.getAccessToken(), lib.getBook()));
            libraryInfo.setId(lib.getId());
            libraryInfo.setIssueDate(lib.getIssuedate());
            libraryInfo.setReturnDate(lib.getReturndate());
            allLibraryInfo.add(libraryInfo);
        });
        return ResponseEntity.status(HttpStatus.OK).body(allLibraryInfo);
    }

    @GetMapping
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userServiceProxy.allUsers(TokenProvider.getAccessToken()));
    }

    @PostMapping
    public ResponseEntity<UserInfo> addUser(@RequestBody final UserInfo user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userServiceProxy.addUser(TokenProvider.getAccessToken(),user));
    }

    @PutMapping("{user_id}")
    public ResponseEntity<UserInfo> updateUser(@PathVariable(value = "user_id") final int userId,
                                               @RequestBody final UserInfo user) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userServiceProxy.updateUser(TokenProvider.getAccessToken(),userId, user));
    }

    @DeleteMapping("{user_id}")
    @PreAuthorize("hasRole('ROLE_admin')")
    public ResponseEntity<String> deleteUser(@PathVariable(value = "user_id") final int userId) {
        this.libraryService.deleteBookRecords(userId);
        return ResponseEntity.status(HttpStatus.OK).body(this.userServiceProxy.deleteUser(TokenProvider.getAccessToken(),userId));
    }
}
