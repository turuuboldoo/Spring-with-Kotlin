package com.example.lesson.controller

import com.example.lesson.model.Transaction
import com.example.lesson.service.TransactionDAO
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
@RequestMapping("/transactions")
class TransactionController(var transactionDAO: TransactionDAO) {

    @PostMapping
    fun createTransaction(@RequestBody transaction: Transaction): MutableMap<String, String> {
        transactionDAO.saveTransaction(transaction)

        return Collections.singletonMap("message", "success")
    }

    @GetMapping
    fun viewAllTransactions(): Iterable<Transaction?>? {
        return transactionDAO.getTransactionHistory()
    }

    @GetMapping("/{id}")
    fun viewTransactionById(@PathVariable("id") id: Long): Transaction? {
        val transaction = transactionDAO.getTransaction(id)

        if (transaction != null && transaction.isPresent) {
            return transaction.get()
        }

        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found!")
    }
}
