package com.tuling.xxy.aspect;

import com.tuling.xxy.constant.ReplaceHandlerEnum;
import com.tuling.xxy.handler.ReplaceFieldFactory;
import com.tuling.xxy.handler.ReplaceFieldHandler;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 处理枚举字段替换切面
 *
 * @author Xiongxy
 * @date 2021-08-25
 */
@Slf4j
@Aspect
@Component
public class ReplaceFieldAspect {
    /**
     * 处理器工厂
     */
    @Autowired
    private ReplaceFieldFactory facotry;

    /**
     * 切点，使用注解的地方
     */
    @Pointcut("@annotation(com.tuling.xxy.annotation.ReplaceMethod)")
    public void init() {
    }

    /**
     * 环绕通知，获取替换枚举的类型，替换枚举返回值
     *
     * @param point 连接点
     * @return 返回值
     */
    @Around("init()")
    public Object doAfterRunning(ProceedingJoinPoint point) {
        // 获取返回值
        Object retVal = null;
        try {
            // 获取返回值
            retVal = point.proceed();

            // 获取返回对象的类型
            String className = retVal.getClass().getName().substring(retVal.getClass().getName().lastIndexOf(".") + 1);

            // 对应handler处理
            ReplaceFieldHandler handler = facotry.get(ReplaceHandlerEnum.convert(className));
            handler.replace(retVal);

            return retVal;
        } catch (Throwable throwable) {
            log.error("替换枚举变量失败。", throwable);
        }
        return retVal;
    }
}
