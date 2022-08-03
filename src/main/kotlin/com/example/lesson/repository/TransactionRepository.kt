package com.example.lesson.repository

import com.example.lesson.model.Transaction
import org.springframework.data.repository.CrudRepository
import java.util.*

class TransactionRepository : CrudRepository<Transaction, Long> {

    override fun <S : Transaction?> save(entity: S): S {
        TODO("Not yet implemented")
    }

    override fun <S : Transaction?> saveAll(entities: MutableIterable<S>): MutableIterable<S> {
        TODO("Not yet implemented")
    }

    override fun findById(id: Long): Optional<Transaction> {
        TODO("Not yet implemented")
    }

    override fun existsById(id: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableIterable<Transaction> {
        TODO("Not yet implemented")
    }

    override fun count(): Long {
        TODO("Not yet implemented")
    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

    override fun deleteAll(entities: MutableIterable<Transaction>) {
        TODO("Not yet implemented")
    }

    override fun deleteAllById(ids: MutableIterable<Long>) {
        TODO("Not yet implemented")
    }

    override fun delete(entity: Transaction) {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: Long) {
        TODO("Not yet implemented")
    }

    override fun findAllById(ids: MutableIterable<Long>): MutableIterable<Transaction> {
        TODO("Not yet implemented")
    }
}