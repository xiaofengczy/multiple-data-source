package com.study.db.dao.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * FileName: Study Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */
@TableName("t_study")
@Data
public class Study {
  /**
   * 用户ID
   */
  @TableId
  private Long id;
  /**
   * 用户名
   */
  private String name;
  /**
   * 密码
   */
  private String password;

}