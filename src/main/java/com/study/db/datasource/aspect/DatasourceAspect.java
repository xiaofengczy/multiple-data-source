package com.study.db.datasource.aspect;

import com.study.db.datasource.annotion.IDatasouce;
import com.study.db.datasource.config.RoutingDataSource;
import java.lang.reflect.Method;
import java.util.Objects;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * FileName: DatasourceAspect Description:
 *
 * @author caozhongyu
 * @create 2019/9/21
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Aspect
@Component
public class DatasourceAspect {

  @Pointcut("@annotation(com.study.db.datasource.annotion.IDatasouce)"  +
      "|| @within(com.study.db.datasource.annotion.IDatasouce)")
  public void datasourcePointcut() {
  }

  @Around("datasourcePointcut()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    //获取目标对象
    Class targetClazz = pjp.getTarget().getClass();
    //获取目标方法
    MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
    Method targetMethod = methodSignature.getMethod();

    //获取对象和方法上注解值 
    IDatasouce targetDB = (IDatasouce) targetClazz.getAnnotation(IDatasouce.class);
    IDatasouce methodDB = targetMethod.getAnnotation(IDatasouce.class);

    //判断并处理
    if (Objects.nonNull(targetDB) || Objects.nonNull(methodDB)) {
      String value;
      if (Objects.nonNull(methodDB)) {
        value = methodDB.value();
      } else {
        value = targetDB.value();
      }
      RoutingDataSource.setDatasource(value);
    }
    try {
      return pjp.proceed();
    } finally {
      RoutingDataSource.clearDatasource();
    }
  }

}