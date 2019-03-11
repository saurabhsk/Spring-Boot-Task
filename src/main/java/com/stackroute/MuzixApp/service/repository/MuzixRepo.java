package com.stackroute.MuzixApp.service.repository;

import com.stackroute.MuzixApp.service.domain.Muzix;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuzixRepo extends JpaRepository<Muzix, Integer> {
}
