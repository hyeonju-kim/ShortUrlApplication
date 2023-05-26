package com.example.shorturlapplication.service;

import com.example.shorturlapplication.annotations.BigData;
import com.example.shorturlapplication.annotations.IllegalUrlChecking;
import com.example.shorturlapplication.domain.ShortUrlSeq;
import com.example.shorturlapplication.domain.Url;
import com.example.shorturlapplication.domain.UrlDto;
import com.example.shorturlapplication.exception.DuplicatedException;
import com.example.shorturlapplication.repository.ShortUrlCountRepository;
import com.example.shorturlapplication.repository.ShortUrlSeqRepository;
import com.example.shorturlapplication.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final ShortUrlSeqRepository shortUrlSeqRepository;
    private final List<String> illegalUrlList;
    private final ShortUrlCountRepository shortUrlCountRepository;

    // 1. ShortUrlSeq 만들기 로직
    public Integer generateShortUrlSeq(){
        ShortUrlSeq nowShortUrlSeq = shortUrlSeqRepository.findById(1L).orElse(null);
        if(nowShortUrlSeq == null){
            ShortUrlSeq shortUrlSeq = new ShortUrlSeq();
            shortUrlSeq.setId(1L);
            shortUrlSeq.setSeqVal(1);
            shortUrlSeqRepository.save(shortUrlSeq);
            return 1;
        }
        else{
            Integer findSeqVal = nowShortUrlSeq.getSeqVal();
            nowShortUrlSeq.setSeqVal(++findSeqVal);
            return findSeqVal;
        }
    }
    // 2. Short Url 만들기 로직
    @IllegalUrlChecking
    public UrlDto generateShortUrl(String longUrl){

        Integer seq = generateShortUrlSeq();

        if(!urlRepository.existsByLongUrl(longUrl)){
            Url url = new Url();
            url.setLongUrl(longUrl);
            url.setShortUrl("srt" + seq);  // srt1, srt2 ..
            urlRepository.save(url);

            UrlDto urlDto = new UrlDto();
            urlDto.setShortUrl(url.getShortUrl());
            urlDto.setLongUrl(url.getLongUrl());
            return urlDto;

        }else {
            throw new DuplicatedException("이미 등록된 주소입니다!!!!!!!!!!"); // 익셉션 던지기
        }

    }
    // 3. 리다이렉트 위한 longUrl 가져오기 및 카운트 체크추가
    @BigData
    public UrlDto findLongUrl(String shorty) {
        UrlDto urlDto = new UrlDto();
        Optional<Url> findUrl = urlRepository.findByShortUrl(shorty);

        if(findUrl.isPresent()){ // 분기처리 해줘야 한다. 값이 없으면 널포인터 익셉션 터질 수도 있다!!! ..
            urlDto.setShortUrl(findUrl.get().getShortUrl());
            urlDto.setLongUrl(findUrl.get().getLongUrl());
        }
        return urlDto;
    }
}
