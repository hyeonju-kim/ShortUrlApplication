package com.example.shorturlapplication.repository;

import com.example.shorturlapplication.domain.ShortUrlCount;
import com.example.shorturlapplication.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortUrlCountRepository extends JpaRepository<ShortUrlCount, Long> {

    ShortUrlCount findByShortUrl(String shortUrl);

}
