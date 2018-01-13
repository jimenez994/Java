package com.zeus.books.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.books.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
//	List<Book> findAll();
//	@Query(value="insert into users(name) values('helllllo');",nativeQuery=true)
//	ArrayList<Object> findUsers();
}



