package com.study.db.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.db.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * FileName: UserMapper Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}