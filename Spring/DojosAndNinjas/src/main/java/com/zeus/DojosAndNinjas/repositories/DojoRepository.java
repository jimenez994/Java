package com.zeus.DojosAndNinjas.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.zeus.DojosAndNinjas.models.Dojo;

public interface DojoRepository extends PagingAndSortingRepository<Dojo, Long>{
	ArrayList<Dojo> findAll();
    // get all dojos
    @Query("SELECT d FROM Dojo d")
    List<Dojo> findAllDojos();
    
    // get all the names of the dojos
    @Query("SELECT d.name From Dojo d")
    List<Dojo> findAllDojosNames();
    
    // passing params and filtering (still retrieves a list)
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    List<Dojo> getDojoWhereId(Long id);
    
    // passing params and filtering
    @Query("SELECT d FROM Dojo d WHERE id = ?1")
    Dojo getSingleDojoWhereId(Long id);
    
    // Note the int type. It is because it returns the number of rows affected
    @Modifying
    @Query("update Dojo d set d.name = ?1 WHERE d.id = ?2")
    int setNameForOne(String name, Long id);
    
    @Modifying
    @Query("update Dojo d set d.name = ?1")
    int setNameForAll(String name);
    
    @Modifying
    @Query("delete Dojo d WHERE d.id = ?1")
    int deleteOneDojo(Long id);
    
    // get all the names of the dojos with id. If we select all, we get a list of Dojo objects back.
    @Query(value="SELECT * from dojos", nativeQuery=true)
    List<Dojo> findAllDojosNamesWithId();
    
    // get all the names of the dojos with id. If we want to select specific column, we will get a list of Object arrays because it is no longer Dojo objects. Each index of the array will be the column selected respectively. Therefore 0 = id column, 1 = name column
    @Query(value="SELECT id, name from dojos", nativeQuery=true)
    List<Object[]> findAllDojosNamesWithId2();
    
    // get one dojo
    @Query(value="SELECT * FROM dojos WHERE id = ?1", nativeQuery=true)
    Dojo getDojoWhereId1(Long id);
    
    // inner join retrieving only the dojos
    @Query("SELECT d FROM Dojo d JOIN d.ninjas n")
    List<Dojo> joinDojosAndNinjas();
    
    // inner join retrieving dojos and ninjas
    @Query("SELECT d, n FROM Dojo d JOIN d.ninjas n")
    List<Object[]> joinDojosAndNinjas2();
}
