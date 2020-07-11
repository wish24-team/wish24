package com.wish.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wish.Model.NavigationBar;

public interface NavigationBarRepository extends JpaRepository<NavigationBar, Integer>{

	List<NavigationBar> findByDepthAndStatus(String intZero, Integer intOne);

	List<NavigationBar> findByParentIdAndStatus(String parentId, Integer intOne);

	NavigationBar findByNavigationIdAndStatus(Integer navigationId, Integer intOne);

	List<NavigationBar> findByStatus(Integer intZero);

}
