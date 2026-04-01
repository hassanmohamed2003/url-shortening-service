package com.pm.urlshorteningservice.dto

import lombok.Data
import java.sql.Timestamp

@Data
data class UrlResponse(
    val id: Long,
    val url: String,
    val shortCode: String,
    val createdAt: Timestamp?,
    val updatedAt: Timestamp?
)