package com.zeus.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeus.countries.models.Country;
@Repository
public interface CountryRepo extends CrudRepository<Country , Long>{
	List<Country> findAll();
//	task1
	@Query(value="SELECT countries.name,languages.language, languages.percentage FROM countries JOIN languages ON countries.code = languages.country_code WHERE language = ?1 ORDER BY languages.percentage DESC ", nativeQuery=true)
	List<Object[]> task1S(String name);
//	task2
	@Query(value="SELECT countries.name, COUNT(cities.id) FROM countries JOIN cities ON countries.id = cities.country_id GROUP BY countries.name ORDER BY COUNT(cities.id) DESC; ", nativeQuery=true)
	List<Object[]> task2S();
//	task3
	@Query(value="SELECT cities.name, cities.population FROM countries JOIN cities ON countries.id = cities.country_id WHERE countries.name = 'Mexico' ORDER BY cities.population DESC;", nativeQuery=true)
	List<Object[]> task3S();
//	task4
	@Query(value=" SELECT countries.name, languages.percentage FROM countries JOIN languages ON countries.id = languages.country_id WHERE languages.percentage >= 89.00 ORDER BY  languages.percentage DESC;", nativeQuery=true)
	List<Object[]> task4S();
//	task5
	@Query(value=" SELECT countries.name, countries.surface_area, countries.population FROM countries WHERE countries.surface_area <= 501 AND countries.population > 100000;", nativeQuery=true)
	List<Object[]> task5S();
//	task6
	@Query(value="SELECT countries.name, countries.government_form, countries.capital, countries.life_expectancy FROM countries WHERE countries.government_form = 'Constitutional Monarchy' AND countries.capital > 200 AND countries.life_expectancy > 75; ", nativeQuery=true)
	List<Object[]> task6S();
//	task7
	@Query(value="SELECT countries.name As country, cities.name FROM countries JOIN cities ON countries.id = cities.country_id WHERE countries.name = 'Argentina' AND cities.district = 'Buenos Aires' AND cities.population > 500000; ", nativeQuery=true)
	List<Object[]> task7S();
//	task8
	@Query(value="SELECT countries.region, COUNT(countries.name) FROM countries GROUP BY countries.region ORDER BY COUNT(countries.name) DESC;", nativeQuery=true)
	List<Object[]> task8S();
	
	

}
