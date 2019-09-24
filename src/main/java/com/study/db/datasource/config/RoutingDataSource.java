package com.study.db.datasource.config;

import java.util.Map;
import javax.sql.DataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * FileName: RoutingDataSource Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */
public class RoutingDataSource extends AbstractRoutingDataSource {

  private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

  public RoutingDataSource(DataSource dbOne, Map<Object, Object> datasourceMap) {
    super.setDefaultTargetDataSource(dbOne);
    super.setTargetDataSources(datasourceMap);
    super.afterPropertiesSet();
  }

  @Override
  protected Object determineCurrentLookupKey() {
    return getDatasource();
  }

  public static String getDatasource() {
    return contextHolder.get();
  }

  public static void setDatasource(String datasource) {
    contextHolder.set(datasource);
  }

  public static void clearDatasource(){
    contextHolder.remove();
  }

}