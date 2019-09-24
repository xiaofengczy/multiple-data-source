package com.study.db;

import com.study.db.datasource.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * FileName: DBApp Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import(DataSourceConfig.class)
public class DBApp {

  public static void main(String[] args) {
    SpringApplication.run(DBApp.class);
  }

}