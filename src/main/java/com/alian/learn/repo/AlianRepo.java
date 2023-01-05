package com.alian.learn.repo;

import com.alian.learn.entity.Alian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlianRepo extends CrudRepository<Alian, Integer> {
}
