package com.spring.mvc.spittr.data;

import java.util.List;

import com.spring.mvc.spittr.pojo.Spittle;


public interface SpittleRepository {

  List<Spittle> findRecentSpittles();

  List<Spittle> findSpittles(long max, int count);
  
  Spittle findOne(long id);

  void save(Spittle spittle);

}
