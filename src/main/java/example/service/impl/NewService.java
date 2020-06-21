package example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import example.converter.NewConverter;
import example.dto.NewDTO;
import example.entity.CategoryEntity;
import example.entity.NewEntity;
import example.repository.CategoryRepository;
import example.repository.NewRepository;
import example.service.INewService;

public class NewService implements INewService{
	
	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Override
	public NewDTO save(NewDTO newDTO) {
		// TODO Auto-generated method stub
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
		NewEntity newEntity = newConverter.toEntity(newDTO);
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
	}
}
