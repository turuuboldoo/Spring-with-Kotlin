package com.example.lesson.service

import com.example.lesson.model.Transaction
import com.example.lesson.repository.TransactionRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class TransactionService(
    var transactionRepository: TransactionRepository
) : TransactionDAO {

    override fun saveTransaction(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction)
    }

    override fun getTransactionHistory(): Iterable<Transaction?>? {
        return transactionRepository.findAllByOrderByIdDesc()
    }

    override fun getTransaction(id: Long): Optional<Transaction>? {
        return transactionRepository.findById(id)
    }

}