package com.lanou.dao;

import java.util.List;

import com.lanou.bean.Carousel;

public interface ICarouselDao {

	public List<Carousel> getAll() throws Exception;
	
	public void addCarousel(String timg) throws Exception;
	
	public void delCarousel(String id) throws Exception;
	
}
