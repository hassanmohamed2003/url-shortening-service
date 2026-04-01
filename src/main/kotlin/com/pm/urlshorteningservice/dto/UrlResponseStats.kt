package com.pm.urlshorteningservice.dto

import lombok.Data
import java.sql.Timestamp

@Data
data class UrlResponseStats (
    val id: Long,
    val url: String,
    val shortCode: String,
    val createdAt: Timestamp?,
    val updatedAt: Timestamp?,
    val accessCount: Int
)