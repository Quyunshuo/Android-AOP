package com.quyunshuo.aop.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/* 此处一定要定义，否则不会该类不会参与编译 */
@Aspect
public class BehaviorAspect {

    /* 定义切点 */
    @Pointcut("execution(@com.quyunshuo.aop.BehaviorTrace  * *(..))")
    public void annoBehavior() {
    }

    /**
     * 定义怎么切，也可以这么写 @Around("execution(@com.quyunshuo.aop.BehaviorTrace  * *(..))")
     */
    @Around("annoBehavior()")
    public void dealPoint(ProceedingJoinPoint point) throws Throwable {
        //方法执行前
        long begin = System.currentTimeMillis();
        Log.d("qqq", "被切方法执行前");
        // 执行被切的方法
        point.proceed();
        //方法执行完成
        long end = System.currentTimeMillis();
        Log.d("qqq", "被切方法执行结束");
        Log.d("qqq", "被切方法耗时：" + (end - begin) + "ms");
    }
}