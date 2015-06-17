package dao.user;

import dao.pool.KickstarterException;

public interface UserService {
	User getUserInfo(String login, String password) throws KickstarterException;
}
