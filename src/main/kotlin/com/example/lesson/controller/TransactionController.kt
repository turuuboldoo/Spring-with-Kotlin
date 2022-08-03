package com.example.lesson.controller

import com.example.lesson.exception.InvalidTransactionReferenceException
import com.example.lesson.model.Transaction
import com.example.lesson.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class TransactionController {

    @Autowired
    var transactionService: TransactionService? = null

    @PostMapping("/create")
    fun createTransaction(@RequestBody transaction: Transaction): String {
        transactionService?.saveTransaction(transaction)

        return "success"
    }

    @GetMapping("/viewAll")
    fun viewAllTransactions(): Iterable<Transaction?>? {
        return transactionService?.getTransactionHistory()
    }

    @GetMapping("/view/{id}")
    fun viewTransactionById(@PathVariable("id") id: Long): Transaction? {
        val transaction = transactionService?.getTransaction(id)

        if (transaction != null && transaction.isPresent) {
            return transaction.get()
        }

        throw InvalidTransactionReferenceException("Invalid transaction reference provided")
    }
}
