package com.study.db.controller;

import com.study.db.dao.entity.User;
import com.study.db.dao.mapper.UserMapper;
import com.study.db.datasource.annotion.IDatasouce;
import com.study.db.datasource.config.DataSourceType;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: UserController Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */

@RestController
public class UserController {

  @Resource
  private UserMapper userMapper;

  @GetMapping("/getUser")
  @IDatasouce(value = DataSourceType.dbTwo)
  public User getUserById(@RequestParam("id") Integer id){
    User user = userMapper.selectById(id);
    System.out.println(user);
    return user;
  }
}