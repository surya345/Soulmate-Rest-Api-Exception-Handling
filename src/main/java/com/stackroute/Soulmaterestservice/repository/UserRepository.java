package com.stackroute.Soulmaterestservice.repository;

import com.stackroute.Soulmaterestservice.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

@Query("FRom User WHERE name=:Username")
    List<User> getAllUsersByName(@Param("Username")String name);

    @Query("FRom User WHERE age=:Userage")
    List<User> getAllUsersByAge(@Param("Userage")int age);

    @Query("FRom User WHERE gender=:Usergender")
    List<User> getAllUsersByGender(@Param("Usergender")String gender);
}
