package com.example.lesson.model

import javax.persistence.*

@Entity
@Table(name = "transactions")
data class Transaction(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0,
    val fromAccount: String? = null,
    val toSend: String? = null,
    val amount: Double = 0.0
)
