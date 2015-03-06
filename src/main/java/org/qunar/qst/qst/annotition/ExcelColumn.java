package org.qunar.qst.qst.annotition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by ronghaizheng on 15/3/6.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelColumn {

    /**
     * 列标题
     */
    public String headerName();

    /**
     * 列宽度
     */
    public int columnWidth() default 15;

    /**
     * 列高度
     */
    public int columnHeight() default 5;

    /**
     * 字段格式
     */
    public String pattern() default "";

}
