package ru.netology

import calcCommission
import formatOutput
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcCommission_Mastercard_LessMaxAmount() {
        val cardType = "Mastercard"
        val prevAmount = 0
        val amount = 10_000

        val result = calcCommission(
            cardType = cardType,
            prevAmount = prevAmount,
            amount = amount
        )

        assertEquals(0, result)
    }

    @Test
    fun calcCommission_Mastercard_MoreMaxAmount() {
        val cardType = "Mastercard"
        val prevAmount = 8_000_000
        val amount = 10_000

        val result = calcCommission(
            cardType = cardType,
            prevAmount = prevAmount,
            amount = amount
        )

        assertEquals(2_060, result)
    }

    @Test
    fun calcCommission_Visa_shouldCalcMinCommission() {
        val cardType = "Visa"
        val prevAmount = 0
        val amount = 10_000

        val result = calcCommission(
            cardType = cardType,
            prevAmount = prevAmount,
            amount = amount
        )

        assertEquals(3_500, result)
    }

    @Test
    fun calcCommission_Visa_shouldCalcCommission() {
        val cardType = "Visa"
        val prevAmount = 0
        val amount = 1_000_000_000

        val result = calcCommission(
            cardType = cardType,
            prevAmount = prevAmount,
            amount = amount
        )

        assertEquals(7_500_000, result)
    }

    @Test
    fun calcCommission_VkPay_NoCommission() {
        val cardType = "VkPay"
        val prevAmount = 0
        val amount = 1_000_000_000

        val result = calcCommission(
            cardType = cardType,
            prevAmount = prevAmount,
            amount = amount
        )

        assertEquals(0, result)
    }

    @Test
    fun formatOutput() {
        val input = 100

        val result = formatOutput(input)

        assertEquals("Комиссия 100 копеек", result)
    }
}