package com.pm.urlshorteningservice.mapper

import com.pm.urlshorteningservice.dto.UrlRequest
import com.pm.urlshorteningservice.dto.UrlResponse
import com.pm.urlshorteningservice.dto.UrlResponseStats
import com.pm.urlshorteningservice.model.URL

fun UrlRequest.toUrl() = URL(
    url = this.url
)

fun URL.toResponse() = UrlResponse(
    id = this.id,
    url = this.url,
    shortCode = this.shortCode,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt
)

fun URL.toResponseStats() = UrlResponseStats(
    id = this.id,
    url = this.url,
    shortCode = this.shortCode,
    createdAt = this.createdAt,
    updatedAt = this.updatedAt,
    accessCount = this.accessCount
)