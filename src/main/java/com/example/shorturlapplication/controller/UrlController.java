package com.example.shorturlapplication.controller;

import com.example.shorturlapplication.domain.Url;
import com.example.shorturlapplication.domain.UrlDto;
import com.example.shorturlapplication.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UrlController {
    private final UrlService urlService;

    @GetMapping("/basic")
    public String index() {
        return "basic/index";
    }

    // url 입력하면 변환 처리
    @PostMapping("/basic/layout")
    public String Shortening(@RequestParam String longUrl, Model model) {
        UrlDto urlDto = urlService.generateShortUrl(longUrl);
        model.addAttribute("urlDto", urlDto);
        return "basic/layout";
    }

    // shortUrl을 주소창에 입력하면 원래의 사이트로 리다이렉트
    @GetMapping("/{shorty}") // shorty = srt1, srt2 ..
    public String redirectLongUrl(@PathVariable String shorty) {
        UrlDto urlDto = urlService.findLongUrl(shorty);
        String longUrl = urlDto.getLongUrl();
        return "redirect:" + longUrl;
    }


    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<UrlDto> allUrlDtoList = urlService.findAllUrl();
        model.addAttribute("allUrl", allUrlDtoList);
        return "basic/dashboard";
    }

//    @ResponseBody
//    @GetMapping("/dashboard")
//    public Map<String, List<UrlDto>> dashboards() {
//        return urlService.findAllUrl();
//    }
}

