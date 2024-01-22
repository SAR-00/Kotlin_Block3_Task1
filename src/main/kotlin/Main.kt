fun main() {
    calculateCommission("VK pay", 10_000, 15_000)
}

fun calculateCommission(cardType: String = "VK pay", amountPreviousTransfers: Int = 0, transfer: Int): Int {
    if (cardType == "VK pay" && (transfer > 15_000 || amountPreviousTransfers + transfer > 40_000)) {
        return -1
    } else if (transfer > 150_000 || amountPreviousTransfers + transfer > 600_000) {
        return -2
    }
    else {
        return when (cardType) {
            "Mastercard", "Maestro" -> if (amountPreviousTransfers + transfer < 75_000) 0 else (transfer / 100 * 0.6 + 20).toInt()
            "Visa", "Мир" -> if (transfer / 100 * 0.75 > 35) (transfer / 100 * 0.75).toInt() else 35
            else -> 0
        }
    }
}