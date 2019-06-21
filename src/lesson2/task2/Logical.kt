@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr
import lesson4.task1.abs
import kotlin.math.abs
import kotlin.math.sqrt

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    var a : Int
    var b : Int
    a = number / 100 % 10 + number / 1000
    b = number % 10 + number / 10 % 10
    if (a == b) return true else return false
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    if ((x1==x2) || (y1==y2) || (abs(x1-x2)==abs(y1-y2))) return true else return false
}


/**
 * Простая
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int {
    var leap = false
    if (year%4 == 0) leap = true
    if (year%100 == 0) leap = false
    if (year%400 == 0) leap = true

    return when {
        month==4 || month == 6 || month== 9 || month == 11 -> 30
        month == 2 && leap == true -> 29
        month == 2 && leap == false -> 28
        else -> 31

    }


}

/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    if (sqrt(sqr(x2 - x1) + sqr(y2 - y1)) + r1 <= r2) return true else return false
                 }

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    var norm : Boolean
    if (a>r || a>s) {
        if ((r>=b && s>=c) || (r>=c && s>=b)) norm = true else norm = false
    }
    else if (b>r || b>s) {
        if ((r>=a && s>=c) || (r>=c && s>=a)) norm = true else norm = false
    }
    else if (c>r || c>s) {
        if ((r>=b && s>=a) || (r>=a && s>=b)) norm = true else norm = false
    }
    else norm = true
    return norm
}
