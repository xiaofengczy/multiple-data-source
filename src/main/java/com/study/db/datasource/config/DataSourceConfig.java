package com.study.db.datasource.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * FileName: DataSourceConfig Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */
@Configuration
public class DataSourceConfig {

  @Bean("dbOne")
  @ConfigurationProperties(prefix = "spring.datasource.druid.study")
  public DataSource dbOneDatasource(){
    return DruidDataSourceBuilder.create().build();
  }

  @Bean("dbTwo")
  @ConfigurationProperties(prefix = "spring.datasource.druid.user")
  public DataSource dbTwoDatasource(){
    return DruidDataSourceBuilder.create().build();
  }

  @Bean
  @Primary
  public RoutingDataSource dataSource(@Qualifier(value = "dbOne") DataSource dbOne,@Qualifier(value = "dbTwo") DataSource dbTwo){
    Map<Object,Object> datasourceMap = new HashMap<>();
    datasourceMap.put(DataSourceType.dbOne, dbOne);
    datasourceMap.put(DataSourceType.dbTwo, dbTwo);
    return new RoutingDataSource(dbOne,datasourceMap);
  }
}