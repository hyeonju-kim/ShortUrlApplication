package com.example.shorturlapplication.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
public class UrlDto {
    private String shortUrl;
    private String longUrl;
    private LocalDateTime createdAt; //등록날짜
    private LocalDateTime modifeidAt; // 최근날짜
    private int count; //몇번 카운트 되는지
}