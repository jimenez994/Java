package com.zeus.rcode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.rcode.models.Post;

@Repository
public interface PostRepository extends CrudRepository<Post,Long>{
	List<Post> findAll();
	
//	@Query(value="SELECT * As posts FROM post JOIN user ON post.user_id = user.id JOIN friendships ON friendships.friend_id = user.id WHERE friendships.user_id = ?1", nativeQuery=true)
//    List<Object[]> findAllFriendsPost(Long id);
//	

}
