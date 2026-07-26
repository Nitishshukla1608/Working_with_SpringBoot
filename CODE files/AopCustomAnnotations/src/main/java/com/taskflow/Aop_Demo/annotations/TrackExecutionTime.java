package com.taskflow.Aop_Demo.annotations;

// Configured annotation
// without configuration annotations are called marker annotation
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TrackExecutionTime {

    long warnAfter() default 2000;

    String operation() default "";
}
