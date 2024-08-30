// Ejercicio 2
interface FizzBuzzLogic {
    fun evaluate(number: Int): String
}

class FizzBuzz : FizzBuzzLogic {
    override fun evaluate(number: Int): String {
        if (number <= 0) {
            throw IllegalArgumentException("Number must be greater than zero")
        }
        
        return buildString {
            if (number % 3 == 0) append("Fizz")
            if (number % 5 == 0) append("Buzz")
            if (isEmpty()) append(number.toString())
        }
    }
}

class FizzBuzzRunner(
    private val fizzBuzzLogic: FizzBuzzLogic, 
    private val range: IntRange,
    private val itemsPerLine: Int = 10 
) {
    fun run() {
        val results = range.map { fizzBuzzLogic.evaluate(it) }
        
       
        println("FizzBuzz Results:")
        println("-".repeat(50))

        results.chunked(itemsPerLine).forEach { line ->
            println(line.joinToString(" ") { it.padEnd(8) })
        }

        println("-".repeat(50))
        println("Total numbers processed: ${range.count()}")
    }
}

fun main() {
    val fizzBuzzRunner = FizzBuzzRunner(FizzBuzz(), 1..100)
    fizzBuzzRunner.run()
}
