package com.ciclo3.Sprint3.Repositories;

import com.ciclo3.Sprint3.Models.UsersApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsersApplication extends JpaRepository<UsersApplication,String> {
}
