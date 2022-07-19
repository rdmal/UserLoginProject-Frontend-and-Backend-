package com.ust.UserBackEndProject.dao;

import com.ust.UserBackEndProject.model.Users;

import java.util.List;
import java.util.Optional;
import java.util.Random;

public interface UsersDao {
    default int insertUsers( Users users) {
        Random rand = new Random();
        int id = rand.nextInt();
        return insertUsers(id, users);
    }
    int insertUsers(int id,Users users );
    int updateUsers(int id, Users users);
    int deleteUsers(int id);
    List<Users> queryUsers();
    Optional<Users> queryUsers(int id);

}
