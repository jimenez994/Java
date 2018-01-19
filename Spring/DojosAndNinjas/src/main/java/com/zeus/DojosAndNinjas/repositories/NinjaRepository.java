package com.zeus.DojosAndNinjas.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zeus.DojosAndNinjas.models.Ninja;

public interface NinjaRepository extends PagingAndSortingRepository<Ninja, Long>{
	
    @Query("SELECT d,n FROM Dojo d")
    List<Object> findAllDojos();
	
	
}
