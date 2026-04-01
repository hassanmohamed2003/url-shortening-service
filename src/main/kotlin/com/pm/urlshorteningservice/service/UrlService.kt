package com.pm.urlshorteningservice.service

import com.pm.urlshorteningservice.dto.UrlRequest
import com.pm.urlshorteningservice.dto.UrlResponse
import com.pm.urlshorteningservice.dto.UrlResponseStats
import com.pm.urlshorteningservice.mapper.toResponse
import com.pm.urlshorteningservice.mapper.toResponseStats
import com.pm.urlshorteningservice.model.URL
import com.pm.urlshorteningservice.repository.UrlRepository
import com.pm.urlshorteningservice.utils.generateShortCode
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UrlService(private val urlRepository: UrlRepository) {

    fun createShortUrl(urlRequest: UrlRequest): UrlResponse {
        val url = URL(
            url = urlRequest.url
        );

        url.shortCode = generateShortCode();

        val savedUrl = urlRepository.save(url);

        return savedUrl.toResponse();
    }

    fun getOriginalUrl(code: String): UrlResponse {
        val url = urlRepository.findByShortCode(code) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND);
        return url.toResponse();
    }

    fun updateShortUrl(code: String, urlRequest: UrlRequest): UrlResponse {
        val url = urlRepository.findByShortCode(code) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        url.url = urlRequest.url

        url.shortCode = generateShortCode();

        val savedUrl = urlRepository.save(url);

        return savedUrl.toResponse();
    }

    fun deleteShortUrl(code: String) {
        val url = urlRepository.findByShortCode(code) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        urlRepository.delete(url);

    }

    fun getStatistics(code: String): UrlResponseStats {
        val url = urlRepository.findByShortCode(code) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        return url.toResponseStats();
    }

    fun redirect(code: String): String {
        val url = urlRepository.findByShortCode(code) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

        url.accessCount += 1;

        urlRepository.save(url)

        return url.url;
    }
}