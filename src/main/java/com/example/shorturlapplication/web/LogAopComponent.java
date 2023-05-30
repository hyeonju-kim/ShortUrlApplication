package com.example.shorturlapplication.web;

import com.example.shorturlapplication.domain.ShortUrlCount;
import com.example.shorturlapplication.domain.UrlDto;
import com.example.shorturlapplication.exception.IllegalUrlException;
import com.example.shorturlapplication.repository.ShortUrlCountRepository;
import com.example.shorturlapplication.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import java.util.List;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class LogAopComponent {

    private final List<String> illegalUrlList;
    private final ShortUrlCountRepository shortUrlCountRepository;
    private final UrlRepository urlRepository;

    ShortUrlCount shortUrlCount = new ShortUrlCount();

    @Around("@annotation(com.example.shorturlapplication.annotations.IllegalUrlChecking)")
    public Object aroundTransaction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        Object[] argument = proceedingJoinPoint.getArgs();
        String target = (String) argument[0];
        log.info(target);

        //Before
        for (String list : illegalUrlList) {
            if (target.contains(list)) {
                throw new IllegalUrlException("naver, daum은 등록할 수 없습니다 ! ");
            }
        }

        Object result =  proceedingJoinPoint.proceed();
        //After

        return result;
    }

    @Around("@annotation(com.example.shorturlapplication.annotations.BigData)")
    public Object bigDataCheck(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        //Before
        Object result =  proceedingJoinPoint.proceed();

        //After
        UrlDto dto = (UrlDto) result;

        if(dto.getShortUrl() != null && dto.getLongUrl() != null){
            shortUrlCount.setShortUrl(dto.getShortUrl());
            shortUrlCount.setCount(shortUrlCount.getCount() + 1);
            shortUrlCountRepository.save(shortUrlCount);
        }

        return result;
    }
}
