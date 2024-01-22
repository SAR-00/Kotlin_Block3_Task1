import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun testDefaultArguments() {
        val result = calculateCommission(transfer = 0)

        assertEquals(0, result)
    }

    @Test
    fun testCommission_Mastercard() {
        val cardType = "Mastercard"
        val amountPreviousTransfers = 30_000
        val transfer = 100_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(610, result)
    }

    @Test
    fun testNoCommission_Mastercard() {
        val cardType = "Mastercard"
        val amountPreviousTransfers = 30_000
        val transfer = 34_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(0, result)
    }

    @Test
    fun testCommission_Maestro() {
        val cardType = "Maestro"
        val amountPreviousTransfers = 30_000
        val transfer = 100_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(620, result)
    }

    @Test
    fun testCommission_Visa() {
        val cardType = "Visa"
        val amountPreviousTransfers = 20_000
        val transfer = 10_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(75, result)
    }

    @Test
    fun testCommission_Mir() {
        val cardType = "Мир"
        val amountPreviousTransfers = 20_000
        val transfer = 10_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(75, result)
    }

    @Test
    fun testMinCommission_Visa() {
        val cardType = "Visa"
        val amountPreviousTransfers = 0
        val transfer = 4000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(35, result)
    }

    @Test
    fun testCommission_VkPay() {
        val cardType = "VK pay"
        val amountPreviousTransfers = 10_000
        val transfer = 15_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(0, result)
    }

    @Test
    fun testTransferLimit_VkPay() {
        val cardType = "VK pay"
        val amountPreviousTransfers = 0
        val transfer = 20_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(-1, result)
    }

    @Test
    fun testMonthlyTransferLimit_VkPay() {
        val cardType = "VK pay"
        val amountPreviousTransfers = 40_000
        val transfer = 15_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(-1, result)
    }

    @Test
    fun testTransferLimit_OtherType() {
        val cardType = "Мир"
        val amountPreviousTransfers = 0
        val transfer = 160_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(-2, result)
    }

    @Test
    fun testMonthlyTransferLimit_OtherType() {
        val cardType = "Мир"
        val amountPreviousTransfers = 600_000
        val transfer = 150_000

        val result = calculateCommission(cardType, amountPreviousTransfers, transfer)

        assertEquals(-2, result)
    }

}