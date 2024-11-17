package com.example.createaccountapp

import org.junit.Test
import org.junit.jupiter.api.Assertions.*

import org.junit.Assert.assertEquals

class CredentialsManagerTest1 {

    // Test empty email
    @Test
    fun givenEmptyPassword_thenReturnFalse() {
        val credentialsManager = CredentialsManager()

        val isEmailValid = credentialsManager.isEmailValid("")

        assertEquals(false, isEmailValid)
    }


}