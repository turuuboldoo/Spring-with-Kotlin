package com.example.lesson.exception

class InvalidTransactionReferenceException(errorMessage: String?) : RuntimeException(errorMessage) {
    companion object {
        private const val serialVersionUID = 1L
    }
}