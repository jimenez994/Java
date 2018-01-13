package com.zeus.group_languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.group_languages.models.Crud;

@Repository
public interface groupLanguageRepository extends CrudRepository<Crud, Long>{

}
