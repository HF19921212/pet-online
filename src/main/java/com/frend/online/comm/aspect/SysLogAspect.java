package com.frend.online.comm.aspect;

import com.frend.online.comm.annotation.SystemLog;
import com.frend.online.core.entity.LogEntity;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.frend.online.core.service.LogEntityService;

import java.lang.reflect.Method;

@Aspect
public class SysLogAspect {

    private static Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

    @Autowired
    private LogEntityService logEntityService;

    //配置接入点,如果不知道怎么配置,可以百度一下规则
    @Pointcut("execution(* controller..*.*(..))")
    private void controllerAspect(){}//定义一个切入点

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {

        //常见日志实体对象
        LogEntity log = new LogEntity();

        //方法通知前获取时间,为什么要记录这个时间呢？当然是用来计算模块执行时间的
        long start = System.currentTimeMillis();
        // 拦截的实体类，就是当前正在执行的controller
        Object target = pjp.getTarget();
        // 拦截的方法名称。当前正在执行的方法
        String methodName = pjp.getSignature().getName();
        // 拦截的方法参数
        Object[] args = pjp.getArgs();
        // 拦截的放参数类型
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Class[] parameterTypes = msig.getMethod().getParameterTypes();

        Object object = null;
        // 获得被拦截的方法
        Method method = null;
        try {
            method = target.getClass().getMethod(methodName, parameterTypes);
        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (SecurityException e1) {
            e1.printStackTrace();
        }

        if (null != method) {
            // 判断是否包含自定义的注解，说明一下这里的SystemLog就是我自己自定义的注解
            if (method.isAnnotationPresent(SystemLog.class)) {
                SystemLog systemlog = method.getAnnotation(SystemLog.class);
                log.setMODULE(systemlog.module());
                log.setMETHOD(systemlog.methods());
                try {
                    object = pjp.proceed();
                    long end = System.currentTimeMillis();
                    //将计算好的时间保存在实体中
                    log.setRSPONSE_DATA(""+(end-start));
                    log.setCOMMITE("执行成功");
                    //保存进数据库
                    logEntityService.save(log);
                } catch (Throwable e) {
                    long end = System.currentTimeMillis();
                    log.setRSPONSE_DATA(""+(end-start));
                    log.setCOMMITE("执行失败");
                    logEntityService.save(log);
                    logger.info("LOGGER RESULT : {}",log);
                }
            } else {//没有包含注解
                object = pjp.proceed();
            }
        } else { //不需要拦截直接执行
            object = pjp.proceed();
        }
        return object;
    }

}
