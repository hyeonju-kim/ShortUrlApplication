package com.example.shorturlapplication.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Url{
    @Id
    private String shortUrl;

    @Column
    private String longUrl;

    @CreatedDate
    @Column
    private LocalDateTime createdAt; //등록날짜

    @LastModifiedDate
    @Column
    private LocalDateTime modifeidAt; // 최근날짜

    @Column
    private int count; //몇번 카운트 되는지
}