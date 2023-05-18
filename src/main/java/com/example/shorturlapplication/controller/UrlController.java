package com.example.shorturlapplication.controller;

import com.example.shorturlapplication.domain.Url;
import com.example.shorturlapplication.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @GetMapping("/basic")
    public String index() {
        return "/basic/index";
    }

    // url 입력하면 변환 처리
    @PostMapping("/basic/layout")
    public String Shortening(@RequestParam String longUrl, Model model) {
        Url generateUrl = urlService.generateShortUrl(longUrl);
        model.addAttribute("url", generateUrl);
        return "basic/layout";
    }

    // shortUrl을 주소창에 입력하면 원래의 사이트로 리다이렉트
    @GetMapping("/{shorty}") // shorty = srt1, srt2 ..
    public String redirectLongUrl(@PathVariable String shorty) {
        String longUrl = urlService.findLongUrl(shorty);
        return "redirect:" + longUrl;
    }
}

