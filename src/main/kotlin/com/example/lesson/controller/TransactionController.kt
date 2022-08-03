package com.example.lesson.controller

import com.example.lesson.model.Transaction
import com.example.lesson.service.TransactionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*

@RestController
class TransactionController {

    @Autowired
    var transactionService: TransactionService? = null

    @PostMapping("/transactions")
    fun createTransaction(@RequestBody transaction: Transaction): MutableMap<String, String> {
        println("${transaction.fromAccount} and ${transaction.toSend}")

        transactionService?.saveTransaction(transaction)

        return Collections.singletonMap("message", "success")
    }

    @GetMapping("/transactions")
    fun viewAllTransactions(): Iterable<Transaction?>? {
        return transactionService?.getTransactionHistory()
    }

    @GetMapping("/transactions/{id}")
    fun viewTransactionById(@PathVariable("id") id: Long): Transaction? {
        val transaction = transactionService?.getTransaction(id)

        if (transaction != null && transaction.isPresent) {
            return transaction.get()
        }

        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Transaction not found!")
    }
}
