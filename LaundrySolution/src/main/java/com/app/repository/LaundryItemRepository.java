package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.LaundryItem;

public interface LaundryItemRepository extends JpaRepository<LaundryItem, Long> {

}
