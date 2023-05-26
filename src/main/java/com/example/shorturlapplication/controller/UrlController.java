package com.example.shorturlapplication.controller;

import com.example.shorturlapplication.domain.Url;
import com.example.shorturlapplication.domain.UrlDto;
import com.example.shorturlapplication.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @GetMapping("/api/basic")
    public String index() {
        return "ok";
    }

    // url 입력하면 변환 처리
    @PostMapping("/api/basic/layout")
    public UrlDto Shortening(@RequestBody Url url) {
        return urlService.generateShortUrl(url.getLongUrl());
    }

    // shortUrl을 주소창에 입력하면 원래의 사이트로 리다이렉트
    @GetMapping("/api/{shorty}") // shorty = srt1, srt2 ..
    public void redirectLongUrl(@PathVariable String shorty, HttpServletResponse response) throws IOException {
        UrlDto urlDto = urlService.findLongUrl(shorty);
        response.sendRedirect(urlDto.getLongUrl());
    }

}

