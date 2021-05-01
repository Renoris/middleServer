package study.bj.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import study.bj.user.data.PictureData;

public interface PictureDao extends JpaRepository<PictureData, Integer> {
}
