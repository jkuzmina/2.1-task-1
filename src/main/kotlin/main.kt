const val VKPAY = "VkPay"
const val MASTERCARD = "Mastercard"
const val MAESTRO = "Maestro"
const val VISA = "Visa"
const val MIR = "Mir"
const val MAXAMOUNT = 7_500_000
const val MINCOMMISS = 3_500

fun main() {
    val cardType = "Mir"
    val prevAmount = 1000
    val amount = 8000000
    println(formatOutput(calcCommission(cardType, prevAmount, amount)))
}

fun calcCommission(cardType: String, prevAmount: Int = 0, amount: Int): Int{
    val commission = when(cardType){
        MASTERCARD, MAESTRO -> {
            if(prevAmount + amount <= MAXAMOUNT) 0 else 0.006 * amount + 2_000
        }
        VISA, MIR ->{
            if(0.0075 * amount < MINCOMMISS) MINCOMMISS else 0.0075 * amount
        }
        else ->{
            0
        }
    }
    return commission.toInt()
}

fun formatOutput(commission: Int):String{
    return "Комиссия $commission копеек"
}