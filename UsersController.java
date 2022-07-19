package com.ust.UserBackEndProject.api;

import com.ust.UserBackEndProject.model.Users;
import com.ust.UserBackEndProject.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value="Users/")  // localhost:8080/Users/
public class UsersController {
        private final UsersService usersService;
        @Autowired
        public UsersController(UsersService usersService) {
                this.usersService = usersService;
        }

        @PostMapping(value="", consumes = MediaType.APPLICATION_JSON_VALUE)
        int insertUsers( @RequestBody Users users) {
                return usersService.insertUsers(users);
        }
        @PutMapping(value="{id}")
        int updateUsers(@PathVariable("id") int id, @RequestBody Users users ) {
                return usersService.updateUsers( id, users);
        }
        @DeleteMapping(value="{id}")
        int deleteUsers(@PathVariable("id") int id) {
                return usersService.deleteUsers(id);
        }
        @GetMapping
        List<Users> queryUsers() {
                return usersService.queryUsers();
        }
        @GetMapping(value="{id}")
        Optional<Users> queryUsers(@PathVariable("id") int id) {
                return usersService.queryUsers(id);
        }
}
