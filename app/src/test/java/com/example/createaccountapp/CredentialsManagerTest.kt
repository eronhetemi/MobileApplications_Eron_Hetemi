package com.example.createaccountapp

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class CredentialsManagerTest {

    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")

        assertEquals(false, isEmailValid)
    }

}

class CredentialsManager {
    fun isEmailValid(s: String): Any? {
        TODO("Not yet implemented")
    }

}
