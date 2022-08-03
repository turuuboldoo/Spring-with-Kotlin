package com.example.lesson.service

import com.example.lesson.model.Transaction
import java.util.*

interface TransactionDAO {

    fun saveTransaction(transaction: Transaction): Transaction

    fun getTransactionHistory(): Iterable<Transaction?>?

    fun getTransaction(id: Long): Optional<Transaction>?

}