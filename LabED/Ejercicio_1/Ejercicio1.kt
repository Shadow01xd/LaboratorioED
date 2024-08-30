interface NumberType {
    fun isType(number: Int): Boolean
}

object PrimeNumber : NumberType {
    override fun isType(number: Int): Boolean {
        if (number < 2) return false
        val sqrt = kotlin.math.sqrt(number.toDouble()).toInt()
        for (i in 2..sqrt) {
            if (number % i == 0) return false
        }
        return true
    }
}

object EvenNumber : NumberType {
    override fun isType(number: Int): Boolean {
        return number % 2 == 0
    }
}

object OddNumber : NumberType {
    override fun isType(number: Int): Boolean {
        return number % 2 != 0
    }
}

fun countNumberTypes(N: Int, types: List<NumberType>): Map<String, Int> {
    val counts = mutableMapOf<String, Int>()

    for (type in types) {
        counts[type::class.simpleName!!] = (1..N).count { type.isType(it) }
    }

    return counts
}

fun main() {
    println("Por favor, ingrese un número:")
    val input = readLine()
    val N = input?.toIntOrNull()

    if (N == null || N <= 0) {
        println("Por favor, introduce un número entero positivo mayor que 0.")
        return
    }

    val types = listOf(PrimeNumber, EvenNumber, OddNumber)
    val counts = countNumberTypes(N, types)

    for ((type, count) in counts) {
        println("$type count: $count")
    }
}
