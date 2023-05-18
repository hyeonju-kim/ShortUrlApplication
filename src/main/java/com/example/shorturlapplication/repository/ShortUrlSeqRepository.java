package com.example.shorturlapplication.repository;

import com.example.shorturlapplication.domain.ShortUrlSeq;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShortUrlSeqRepository extends JpaRepository<ShortUrlSeq, Long> {

}
