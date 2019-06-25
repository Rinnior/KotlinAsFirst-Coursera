@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.sqr
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */


fun digitNumber(n: Int): Int {
    var num = 0
    var nn = n
    do {
        num++
        nn = nn/10
    }
        while (nn>0)
    return  num

}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда n1 = 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    /*if (n<=2) return 1
    return fib(n-1) + fib(n-2)*/


    var pred = 1
    var predpred = 0
    var result = 1
    if (n==1) return result
    for (i in 2..n){
        result = predpred + pred
        predpred = pred
        pred = result
    }
    return result

}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var max : Int
    var st : Int
    if (m<n) {
        max=n
        st=n
    }
    else {
        max=m
        st=m
    }
    for (i in max..m*n step st){
        if (i%m==0 && i%n==0) return i
    }
    return -1 //случай ошибки

}


/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..n) {
        if (n%i==0) return i
    }
    return n
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var maxd = 0
    for (i in 1..n-1) {
        if (n%i==0) maxd = i
    }
    return maxd
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var max : Int
    var prime = true
    if (m>n) max=n else max=m
    if (m%2==0 && n%2==0) prime=false
    for (i in 3..max step 2) {
        if (m%i==0 && n%i==0) prime=false
    }
    return prime
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var sq = false
    for (i in m..n) {
        if (sqrt(i.toDouble()) == sqrt(i.toDouble()).toInt().toDouble()) sq=true
    }
    return sq
}

/**
 * Средняя
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var steps = 0
    var xx = x
    while (xx!=1) {
        if (xx%2==0){
            xx=xx/2
            steps++
        }
        else {
            xx=3*xx+1
            steps++
        }
    }
    return steps
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun pow(x: Double, p:Int): Double {
    var xx = x
    if (p==0) xx=1.0
    for (i in 2..p){
        xx = xx*x
    }
    return xx
}

fun sin(x: Double, eps: Double): Double {
    var xx = x
    var sign = 1.0
    var ar = 1
    var sum = 0.0
    while (abs(xx)>=eps) {
        xx = sign*(pow(xx,ar)/factorial(ar))
        sum = sum + xx
        sign = sign*(-1.0)
        ar = ar + 2

    }
    return sum
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var n1 = n
    var n2 = 0
    do {
        n2 = n2*10 + n1%10
        n1 = n1/10
    }
        while (n1>=1)
    return n2
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean {
    if (n == revert(n)) return true else return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var s = n%10
    var nn = n/10
    var isd = false
    do {
        if (nn%10 != s) isd=true
            nn = nn/10
        }
        while (nn>0)
    return isd
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun len(n: Int): Int {
    var i = 0
    var nn = n
    do {
        i++
        nn = nn/10
    }
        while (nn>=1)
    return i
}

fun pow(x: Int, p:Int): Int {
    var xx = x
    if (p==0) xx=1
    for (i in 2..p){
        xx = xx*x
    }
    return xx
}

fun squareSequenceDigit(n: Int): Int {
    var i = 1
    var sq = 0
    var raw = 0
    while (true) {
        sq = sqr(i)
        if (raw+len(sq)<n) {
            raw = raw + len(sq)
            i++
        }
        else {
            for (a in 1..len(sq)){
                if (raw+a == n){
                    return (sq/pow(10, len(sq)-a))%10
                }

            }
        }

    }
    return -1 //ошибка

}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
    var i = 1
    var sq = 0
    var raw = 0
    while (true) {
        sq = fib(i)
        if (raw+len(sq)<n) {
            raw = raw + len(sq)
            i++
        }
        else {
            for (a in 1..len(sq)){
                if (raw+a == n){
                    return (sq/pow(10, len(sq)-a))%10
                }

            }
        }

    }
    return -1 //ошибка
}
