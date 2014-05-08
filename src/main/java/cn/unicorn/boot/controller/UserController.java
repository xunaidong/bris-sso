package cn.unicorn.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.unicorn.boot.domain.User;
import cn.unicorn.boot.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private UserServiceImpl userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public Iterable<User> findAll() {
		return userService.findAllUser();
	}
	@RequestMapping(value = "/{userNo}", method = RequestMethod.GET)
	@ResponseBody
	public User findUser(@PathVariable("userNo") String userNo) {
		Assert.hasText(userNo, "user_no is blank!");
		User user = userService.getUser(userNo);
		Assert.notNull(user, "无效的用户编号!");
		return user;
	}
	@RequestMapping(value = "/{userNo}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteUser(@PathVariable("userNo") String userNo) {
		Assert.hasText(userNo, "user_no is blank!");
		userService.deleteUserByNo(userNo);;
	}
	@RequestMapping(value = "/{userNo}", method = RequestMethod.PUT)
	@ResponseBody
	public void updateUser(@PathVariable("userNo") String userNo) {
		Assert.hasText(userNo, "user_no is blank!");
		userService.deleteUserByNo(userNo);;
	}
	@RequestMapping(value = "/{userNo}", method = RequestMethod.POST)
	@ResponseBody
	public void createUser(@PathVariable("userNo") String userNo) {
		Assert.hasText(userNo, "user_no is blank!");
		userService.deleteUserByNo(userNo);;
	}
	

}
