package com.example.lesson.service

import com.example.lesson.model.Transaction
import com.example.lesson.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService {

    @Autowired
    var transactionRepository: TransactionRepository? = null

    fun saveTransaction(transaction: Transaction?) {
        transactionRepository?.save(transaction)
    }

    fun getTransactionHistory(): Iterable<Transaction?>? {
        return transactionRepository?.findAll()
    }

    fun getTransaction(id: Long): Optional<Transaction>? {
        return transactionRepository?.findById(id)
    }

}