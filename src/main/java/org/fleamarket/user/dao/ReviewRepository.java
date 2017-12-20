package org.fleamarket.user.dao;

import org.fleamarket.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer>{
	Review findById(int id);
}
