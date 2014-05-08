package cn.unicorn.boot.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import cn.unicorn.boot.dao.UserRepository;
import cn.unicorn.boot.domain.User;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;
	//private static Logger _log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Transactional(value = TxType.NOT_SUPPORTED)
	public boolean checkLogin(String username, String password) {
		Assert.hasText(username, "username is blank!");
		Assert.hasText(password, "password is blank!");
		User user = userRepository.findByUsername(username);
		return user != null && user.getPassword().equals(password);
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	public User getUser(String userNo) {
		Assert.hasText(userNo, "userNo is not blank!");
		return userRepository.findOne(userNo);
	}

	@Transactional(value = TxType.REQUIRED, rollbackOn = Exception.class)
	public void saveOrUpdateUser(User user) {
		Assert.notNull(user, "user is null!");
		userRepository.save(user);
	}

	@Transactional(value = TxType.REQUIRED, rollbackOn = Exception.class)
	public void deleteUser(User user) {
		Assert.notNull(user, "user is null!");
		userRepository.delete(user);
	}

	@Transactional(value = TxType.REQUIRED, rollbackOn = Exception.class)
	public void deleteUserByNo(String userNo) {
		Assert.hasText(userNo, "userNo is null!");
		userRepository.delete(userNo);
	}
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Iterable<User> findAllUser() {
		return userRepository.findAll();
	}

}
