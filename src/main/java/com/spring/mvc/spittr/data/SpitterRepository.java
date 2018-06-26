package com.spring.mvc.spittr.data;

import com.spring.mvc.spittr.pojo.Spitter;

public interface SpitterRepository {

  Spitter save(Spitter spitter);
  
  Spitter findByUsername(String username);

}
