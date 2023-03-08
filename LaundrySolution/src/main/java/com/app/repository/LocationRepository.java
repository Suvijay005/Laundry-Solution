package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Location;

public interface LocationRepository extends JpaRepository<Location, Long>{

}
