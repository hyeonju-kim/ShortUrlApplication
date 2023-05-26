package com.example.shorturlapplication.repository;

import com.example.shorturlapplication.domain.Url;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url,Long> {

    boolean existsByLongUrl(String longUrl);

    Optional<Url> findByShortUrl(String shortUrl);

    Optional<Url> findByLongUrl(String longUrl);
}
