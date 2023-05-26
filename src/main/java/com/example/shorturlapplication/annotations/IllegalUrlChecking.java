package com.example.shorturlapplication.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//2. Retention, Target 애노테이션을 잊지 말고 붙여라
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IllegalUrlChecking{ // 특정 사이트 차단하도록 체크하는 어노테이션
}
