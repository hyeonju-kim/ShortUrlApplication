package com.example.shorturlapplication.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
public class UrlDto {
    private String shortUrl;
    private String longUrl;
}