package com.anime.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.anime.bean.Ani;
import com.anime.msg.req.AniPageReq;

@Mapper
@Repository
public interface AniDao {

	public void insertAni(Ani ani) throws SQLException;
	
	public void deleteAni(Integer[] ids) throws SQLException;
	
	public void updateAni(Ani ani) throws SQLException;
	
	public Ani selectAniById(Integer id) throws SQLException;
	
	public List<Ani> selectAniByPage(AniPageReq aniPageReq) throws SQLException;
	
	public Integer selectNextId() throws SQLException;
	
	public Integer selectTotalCount() throws SQLException;
	
	public int plusOne(Integer id) throws SQLException;
	
	public int total() throws SQLException;
}
