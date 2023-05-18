package com.example.shorturlapplication.service;

import com.example.shorturlapplication.domain.ShortUrlSeq;
import com.example.shorturlapplication.domain.Url;
import com.example.shorturlapplication.repository.ShortUrlSeqRepository;
import com.example.shorturlapplication.repository.UrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {
    private final UrlRepository urlRepository;
    private final ShortUrlSeqRepository shortUrlSeqRepository;

    @Value("${portal.address}")
    private String portalAddress;

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
    public Url generateShortUrl(String longUrl){
        Url url = new Url();
        Integer seq = generateShortUrlSeq();

        if (!urlRepository.existsByLongUrl(longUrl)) {
            url.setLongUrl(longUrl);
            url.setShortUrl(portalAddress + "srt" + seq);  // srt1, srt2 ..
            urlRepository.save(url);
            return url;
        }else {
            return url;
        }
    }
    // 3. 리다이렉트 위한 longUrl 가져오기
    public String findLongUrl(String shorty) {
        String shortUrl = portalAddress + shorty;
        Url findUrl = urlRepository.findByShortUrl(shortUrl).orElse(null);
        return findUrl.getLongUrl();
    }
}
