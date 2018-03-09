package com.drp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.drp.pojo.Fiscal;
import com.drp.repository.FiscalRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean-base.xml")
@Transactional
@Rollback(value = false)
public class FiscalTses {

	@Autowired
	private FiscalRepository fiscalRepository;
	
	@Test
	public void save() throws Exception {
		Fiscal fiscal = new Fiscal(3, "2017", "1", "2017-1-1", "2017-1-2", "否");
		fiscalRepository.save(fiscal);
	}
	@Test
	public void update() throws Exception {
		Fiscal fiscal = new Fiscal(3, "2017", "1", "2017-1-1", "2017-1-2", "是");
		System.out.println(fiscal);
		fiscalRepository.updateFiscal(fiscal.getFiscalYear(),fiscal.getFiscalPeriod(),fiscal.getBeginDate(),fiscal.getEndDate(),fiscal.getPeriodflag(),fiscal.getId());	
	}

}
