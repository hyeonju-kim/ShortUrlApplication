package com.example.shorturlapplication.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class ShortUrlCount {
    @Id
    private String shortUrl;

    @Column
    private int count;
}
