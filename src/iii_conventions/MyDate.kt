package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {

    constructor(date: MyDate) : this(date.year, date.month, date.dayOfMonth)

    override fun compareTo(other: MyDate): Int = when {
        this.year != other.year -> this.year - other.year
        this.month != other.month -> this.month - other.month
        else -> this.dayOfMonth - other.dayOfMonth
    }

    //    override fun compareTo(other: MyDate): Int {
//        if (other != null && other is MyDate) {
//            val otherDate: MyDate = other
//            if (this.year.compareTo(otherDate.year) > 0) {
//                return 1
//            } else if (this.year.compareTo(otherDate.year) == 0) {
//                if (this.month.compareTo(otherDate.month) > 0) {
//                   return 1
//                } else if(this.month.compareTo(otherDate.month) == 0) {
//                    if (this.dayOfMonth.compareTo(otherDate.dayOfMonth) > 0) {
//                      return  1
//                    } else if(this.dayOfMonth.compareTo(otherDate.dayOfMonth) == 0) {
//                       return 0
//                    } else {
//                      return  -1
//                    }
//                } else {
//                   return -1
//                }
//            } else {
//               return -1
//            }
//        }
//        return -1
//    }
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)
operator fun TimeInterval.times(number: Int) = RepeatedTimeInterval(this, number)

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return DateIterator(start, endInclusive)
    }
}

class DateIterator(start: MyDate, val endInclusive: MyDate) : Iterator<MyDate> {

    var nextDate: MyDate = MyDate(start)

    override fun hasNext(): Boolean {
        return nextDate <= endInclusive
    }

    override fun next(): MyDate {
        val result = nextDate
        nextDate = nextDate.nextDay()
        return result
    }
}
