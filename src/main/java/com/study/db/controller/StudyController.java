package com.study.db.controller;

import com.study.db.dao.entity.Study;
import com.study.db.dao.mapper.StudyMapper;
import com.study.db.datasource.annotion.IDatasouce;
import com.study.db.datasource.config.DataSourceType;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * FileName: StudyController Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */
@RestController
@IDatasouce(value = DataSourceType.dbOne)
public class StudyController {

  @Resource
  private StudyMapper studyMapper;

  @GetMapping("/getStudy")
  public Study getStudyById(@RequestParam("id") Integer id){
    return studyMapper.selectById(id);
  }

}