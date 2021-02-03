package com.lanou.service;

import java.util.List;

import com.lanou.bean.Carousel;
import com.lanou.dao.CarouselDaoImp;
import com.lanou.dao.ICarouselDao;

public class CarouselServiceImp implements ICarouselService{

	private ICarouselDao carouselDao = new CarouselDaoImp();
	@Override
	public List<Carousel> getAll() throws Exception {
		// TODO Auto-generated method stub
		return carouselDao.getAll();
	}
	@Override
	public void addCarousel(String timg) throws Exception {
		// TODO Auto-generated method stub
		carouselDao.addCarousel(timg);
		
	}
	@Override
	public void delCarousel(String id) throws Exception {
		// TODO Auto-generated method stub
		carouselDao.delCarousel(id);
		
	}

}
