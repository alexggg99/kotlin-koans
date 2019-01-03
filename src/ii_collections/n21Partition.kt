package ii_collections

import javax.swing.text.html.parser.Entity

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
//    val customerToOrders = this.customers.map{ mapOf(it to it.orders)}
//    return customerToOrders.sortedBy { compareValuesBy(a, b, it.size) }.get(0).keys
    return this.customers.filter {
        val (delivered, notdelivered) = it.orders.partition { it.isDelivered }
        notdelivered.size > delivered.size
    }.toSet()
}
