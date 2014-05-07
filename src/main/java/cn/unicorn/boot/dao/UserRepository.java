package cn.unicorn.boot.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.unicorn.boot.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findByUsername(String username);

}