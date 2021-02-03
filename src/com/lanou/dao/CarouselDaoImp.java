package com.lanou.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Carousel;
import com.lanou.bean.User;
import com.lanou.util.JDBCUtil;

public class CarouselDaoImp implements ICarouselDao{

	@Override
	public List<Carousel> getAll() throws Exception {
		String sql = "select * from t_Carousel";
		
		List<Carousel> listcarousel = new ArrayList<>();
		ResultSet rs = JDBCUtil.qeuryUtil(sql, null);
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String timg = rs.getString("timg");
			Carousel carousel = new Carousel(id, timg);
			listcarousel.add(carousel);
		
	}
		return listcarousel;

}

	@Override
	public void addCarousel(String timg) throws Exception {
		 String sql = "insert into t_Carousel (timg) values (?)";
		    Object[] os= {timg};
		    JDBCUtil.addDeleteUpdate(sql, os);
		
	}

	@Override
	public void delCarousel(String id) throws Exception {
		 String sql = "delete from t_Carousel where id=?";
		    Object[] os= {id};
		    JDBCUtil.addDeleteUpdate(sql, os);
	}
	
	
}
