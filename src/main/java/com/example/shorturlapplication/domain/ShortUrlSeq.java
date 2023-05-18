package com.example.shorturlapplication.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
public class ShortUrlSeq {
    @Id
    @Column(name = "SEQ_ID")
    private Long id;

    @Column(name = "SEQ_VAL")
    private Integer seqVal;
}
