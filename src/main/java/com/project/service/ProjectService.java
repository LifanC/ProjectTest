package com.project.service;

import java.util.*;
import com.project.entity.*;

public interface ProjectService {
	ProductNumber saveProductNumber(ProductNumber productNumber);

	List<ProductNumber> findAll();

	List<ProductNumber> queryByProductnumber(String productnumber);

	void deleteByProductnumber(Integer id);

	Integer setByProductnumber(Integer id);
}
