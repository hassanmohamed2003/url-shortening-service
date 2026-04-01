package com.pm.urlshorteningservice.model

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp

@Entity
data class URL(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var url: String,

    @Column(unique = true)
    var shortCode: String = "",

    @CreationTimestamp
    var createdAt: Timestamp? = null,

    @UpdateTimestamp
    var updatedAt: Timestamp? = null,

    var accessCount: Int = 0
)