package study.bj.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import study.bj.user.data.User;

public interface UserDao extends JpaRepository<User, Integer> {
}
