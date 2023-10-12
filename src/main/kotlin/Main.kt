
fun main(args: Array<String>) {
    //println(test(3,4))
    val x : () -> Unit = { println("Hello") }
    x()
    val x1 = { println("Hello") }
    x1()
    val result : (String) -> Unit = {message: String -> println(message)}
    result("Hello")

    val sum = {x: Int, y: Int -> println(x+y)}
    sum(2,3)

    val sum2 : (Int, Int) -> Unit = {x: Int, y: Int -> val r = x+y; println(r) }

    val sum3 : (Int, Int) -> Int = {x: Int, y: Int ->
        val r = x+y
        r
    }
    println(sum3(5,6)) // 11
    // передал в функию лямбда выражение
    doOperation(10,12, { x: Int, y: Int -> 2*x*y})
    doOperation(10,12) { x: Int, y: Int -> 2 * x * y }
    doOperation { i, i2 -> sum3(i,i2)}
    doOperation (op = sum3)
    doOperation(20,21, fun(x: Int, y: Int) = x*y+100)

    var r1 = bigFun(1)
    println(r1(10,12))

    // анонимная функция
    val p = fun() = println("123123")
    p()
}

fun bigFun(k: Int) : (Int, Int) -> Int {
    when(k) {
        1 -> return fun(x: Int, y: Int) = (x+y)*2
        2 -> return {x: Int, y:Int -> x*x*y*y}
        else -> return fun(x: Int, y: Int) = 5
    }
}


fun doOperation(a: Int = 2, b: Int = 2, op: (Int, Int) -> Int) {
    println(op(a,b))
}


fun test(a: Int, b: Int) {

}