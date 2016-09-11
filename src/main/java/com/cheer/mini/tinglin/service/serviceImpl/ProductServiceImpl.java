package com.cheer.mini.tinglin.service.serviceImpl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cheer.mini.base.Page;
import com.cheer.mini.base.util.StringUtil;
import com.cheer.mini.ums.dao.ProductMapper;
import com.cheer.mini.ums.model.Product;
import com.cheer.mini.ums.model.ProductExample;
import com.cheer.mini.ums.model.ProductExample.Criteria;
import com.cheer.mini.tinglin.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private Logger logger = Logger.getLogger(getClass());

	@Autowired
	ProductMapper proMapper;

	private static String ADMIN_ID = "ADMIN1E35D8911E68C9F3C970ED7EF76";

	@Override
	@Transactional
	public void save(Product proInfo) {
		logger.info("Input Param [proInfo] -> " + proInfo);
		proInfo.setCreatorFk(ADMIN_ID);
		proInfo.setUpdaterFk(ADMIN_ID);
		proInfo.setDateCreate(new Date());
		proInfo.setDateUpdate(new Date());
		proInfo.setIsValid((short) 2);
		proMapper.insert(proInfo);
	}

	@Override
	public void update(Product proInfo) {
		logger.info("Input Param [proInfo] -> " + proInfo);
		proInfo.setCreatorFk(ADMIN_ID);
		proInfo.setUpdaterFk(ADMIN_ID);
		proInfo.setDateCreate(new Date());
		proInfo.setDateUpdate(new Date());
		proInfo.setIsValid((short) 2);
		proMapper.updateByPrimaryKey(proInfo);

	}

	@Override
	public List<Product> list(Product condition, Page page) {
		ProductExample proex = new ProductExample();
		Criteria criteria = proex.createCriteria();
		if (condition != null && StringUtil.notEmpty(condition.getName())) {
			criteria.andNameLike(condition.getName() + "%");
		}
		if (page != null) {
			proex.setPage(page);
		}

		return proMapper.selectByExample(proex);
	}

	@Override
	public Product info(String proInfo) {

		return proMapper.selectByPrimaryKey(proInfo);
	}

	@Override
	@Transactional
	public void delete(String proInfo) {
		proMapper.deleteByPrimaryKey(proInfo);

	}

	@Override
	public Integer count(Product condition) {
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		if (condition != null && StringUtil.notEmpty(condition.getName())) {
			criteria.andNameLike(condition.getName());
		}
		return proMapper.selectCountByExample(example);
	}

}
