package com.lwj.house.repository;

import com.lwj.house.entity.HouseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author lwj
 */
@Repository
public interface HouseDetailRepository extends JpaRepository<HouseDetail, Integer> {

}
