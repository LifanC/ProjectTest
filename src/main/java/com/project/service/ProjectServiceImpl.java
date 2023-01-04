package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import com.project.entity.*;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public ProductNumber saveProductNumber(ProductNumber productNumber) {
		// TODO Auto-generated method stub
		return projectRepository.save(productNumber);
	}

	@Override
	public List<ProductNumber> findAll() {
		// TODO Auto-generated method stub
		return projectRepository.findAll();
	}

	@Override
	public List<ProductNumber> queryByProductnumber(String productnumber) {
		// TODO Auto-generated method stub
		return projectRepository.queryByProductnumber(productnumber);
	}

	@Override
	public void deleteByProductnumber(Integer id) {
		// TODO Auto-generated method stub
		projectRepository.deleteById(id);
	}

	@Override
	public Integer setByProductnumber(Integer id) {
		// TODO Auto-generated method stub
		return projectRepository.setByProductnumber(id);
	}

	
	
}
