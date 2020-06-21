package example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import example.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{
	
}