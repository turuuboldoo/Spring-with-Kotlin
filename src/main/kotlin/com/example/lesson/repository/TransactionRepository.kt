package com.example.lesson.repository

import com.example.lesson.model.Transaction
import org.springframework.data.repository.CrudRepository

interface TransactionRepository : CrudRepository<Transaction, Long> {

    fun findAllByOrderByIdDesc(): Iterable<Transaction?>?
}
