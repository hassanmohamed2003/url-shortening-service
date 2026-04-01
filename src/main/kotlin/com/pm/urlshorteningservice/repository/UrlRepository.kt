package com.pm.urlshorteningservice.repository

import com.pm.urlshorteningservice.model.URL
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface UrlRepository : JpaRepository<URL, Long> {

    fun findByShortCode(shortCode: String): URL?
}