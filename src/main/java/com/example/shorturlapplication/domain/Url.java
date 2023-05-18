package com.example.shorturlapplication.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Url{
    @Id
    private String shortUrl;

    @Column
    private String longUrl;
}