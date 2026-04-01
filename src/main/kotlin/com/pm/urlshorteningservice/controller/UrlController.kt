package com.pm.urlshorteningservice.controller

import com.pm.urlshorteningservice.dto.UrlRequest
import com.pm.urlshorteningservice.dto.UrlResponse
import com.pm.urlshorteningservice.dto.UrlResponseStats
import com.pm.urlshorteningservice.service.UrlService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/shorten")
class UrlController(private val urlService: UrlService) {


    @PostMapping
    fun createShortUrl(@RequestBody urlRequest: UrlRequest): ResponseEntity<UrlResponse> {
        val urlResponse = urlService.createShortUrl(urlRequest)
        return ResponseEntity.status(HttpStatus.CREATED).body(urlResponse)
    }

    @GetMapping("/{code}")
    fun getOriginalUrl(@PathVariable code: String): ResponseEntity<UrlResponse> {
        val urlResponse = urlService.getOriginalUrl(code)
        return ResponseEntity.ok().body(urlResponse)
    }

    @PutMapping("/{code}")
    fun updateShortUrl(@PathVariable code: String, @RequestBody urlRequest: UrlRequest): ResponseEntity<UrlResponse> {
        val urlResponse = urlService.updateShortUrl(code, urlRequest);
        return ResponseEntity.ok().body(urlResponse)
    }

    @DeleteMapping("/{code}")
    fun deleteShortUrl(@PathVariable code: String): ResponseEntity<Void> {
        urlService.deleteShortUrl(code);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{code}/stats")
    fun getStatistics(@PathVariable code: String): ResponseEntity<UrlResponseStats> {
        val urlResponseStats = urlService.getStatistics(code)
        return ResponseEntity.ok().body(urlResponseStats);
    }
}