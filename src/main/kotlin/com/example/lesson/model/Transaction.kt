package com.example.lesson.model

import lombok.Getter
import lombok.Setter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Setter
@Getter
@Entity
class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val transactionId: Long = 0
    val fromAccount: String? = null
    val toAccount: String? = null
    val amount = 0.0
}