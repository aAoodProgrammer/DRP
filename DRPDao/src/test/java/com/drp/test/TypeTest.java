package com.drp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.Category;
import com.drp.repository.CategoryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
@Transactional
@Rollback(value = false)
public class TypeTest {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void test1() throws Exception {
		List<Category> categories = new ArrayList<Category>();
		categories.add(new Category(1, "一级分销商", 1));
		categories.add(new Category(2, "二级分销商", 1));
		categories.add(new Category(3, "三级分销商", 1));
		categories.add(new Category(4, "总部", 1));
		categories.add(new Category(5, "甲级医院", 2));
		categories.add(new Category(6, "乙级医院", 2));
		categories.add(new Category(7, "丙级医院", 2));
		categories.add(new Category(8, "药店", 2));
		categories.add(new Category(9, "其他", 2));
		categories.add(new Category(10, "医疗器械", 3));
		categories.add(new Category(11, "中药", 3));
		categories.add(new Category(12, "西药", 3));
		categories.add(new Category(13, "盒", 4));
		categories.add(new Category(14, "片", 4));
		categories.add(new Category(15, "箱", 4));
		
		categoryRepository.save(categories);
		
	}
	
	@Test
	public void findByCategory() throws Exception {
		List<Category> categories = categoryRepository.queryByCategory(1);
		System.out.println(categories);
	}
	@Test
	public void findIdCategory() throws Exception {
		List<Category> categories = categoryRepository.findCategoryByCategory(1);
		System.out.println(categories);
	}
}
