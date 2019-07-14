package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Period
import java.time.temporal.ChronoUnit
import java.util.*

const val SECOND=1000L
const val MINUTE=SECOND*60
const val HOUR=MINUTE*60
const val DAY=HOUR*24
const val MONTH=DAY*31
const val YEAR=DAY*365

fun Date.format(pattern: String="HH:mm:ss dd.MM.yy"): String{
    val dateFormat=SimpleDateFormat(pattern,Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int,units: TimeUnits=TimeUnits.SECOND):Date{
    var time = this.time
    time+=when (units) {
        TimeUnits.SECOND ->value*SECOND
        TimeUnits.MINUTE->value*MINUTE
        TimeUnits.HOUR->value*HOUR
        TimeUnits.DAY->value*DAY
        TimeUnits.MONTH->value*MONTH
        TimeUnits.YEAR->value*YEAR
        //else->throw IllegalStateException("invalid unit")
    }
    this.time=time
    return this
}

fun Date.getTimeUnitName(value: Long, unit: TimeUnits): String{
    return when (unit) {
        TimeUnits.SECOND -> when (value) {
            in 1..1->"секунда"
            in 2..4 ->"секунды"
            else->"секунд"}
            TimeUnits.MINUTE -> when (value) {
                in 1..1->"минута"
                in 2..4->"минуты"
                else->"минут"
        }
        TimeUnits.HOUR -> when (value) {
            in 1..1->"час"
            in 2..4 ->"часа"
            else->"часов"
        }
        TimeUnits.DAY -> when (value) {
            in 1..1->"день"
            in 2..4 ->"дня"
            else->"дней"
        }
        TimeUnits.MONTH -> when (value) {
            in 1..1->"месяц"
            in 2..4 ->"месяца"
            else->"месяцов"
        }
        TimeUnits.YEAR -> when (value) {
            in 1..1->"год"
            in 2..4 ->"года"
            else->"лет"
        }
        else ->"неизвестно"
    }
}

fun Date.getTimeUnitCount(value: Long, unit: TimeUnits): String{
    return when (unit) {
        TimeUnits.SECOND -> when (value) {
            in 1..60->value.toString()
            else->"несколько"}
        TimeUnits.MINUTE -> when (value) {
            in 1..60->value.toString()
            else->"несколько"}
        TimeUnits.HOUR -> when (value) {
            in 1..24->value.toString()
            else->"почти сутки"}
        TimeUnits.DAY -> when (value) {
            in 1..31->value.toString()
            else->"почти месяц"}
        TimeUnits.MONTH -> when (value) {
            in 1..12->value.toString()
            else->"почти"}
        TimeUnits.YEAR -> when (value) {
            in 1..6->value.toString()
            else->"очень много"}
        else ->"неизвестно"
    }
}


fun Date.huminizeDiff(date: Date = Date()):String {
    val p: Period
    val diff: Long =Date().getTime()-date.getTime()
    val y: Long=diff / YEAR
    val m: Long=diff / MONTH
    val d: Long=diff / DAY
    val h: Long=diff / HOUR
    val mi: Long=diff / MINUTE
    val sec: Long=diff / SECOND
    if (y>0) {return "${getTimeUnitCount(y , TimeUnits.YEAR)} ${getTimeUnitName(y , TimeUnits.YEAR)} ${y} назад"}
    else
    if (m>0) {return "${getTimeUnitCount(m , TimeUnits.MONTH)} ${getTimeUnitName(m , TimeUnits.MONTH)} назад"}
    else
    if (d>0) {return "${getTimeUnitCount(d , TimeUnits.DAY)} ${getTimeUnitName(d , TimeUnits.DAY)} назад"}
    else
    if (h>0) {return "${getTimeUnitCount(h , TimeUnits.HOUR)} ${getTimeUnitName(h , TimeUnits.HOUR)} назад"}
    else
    if (mi>0) {return "${getTimeUnitCount(mi , TimeUnits.MINUTE)} ${getTimeUnitName(mi , TimeUnits.MINUTE)} назад"}
    else
    if (sec>0) {return "${getTimeUnitCount(sec , TimeUnits.SECOND)} ${getTimeUnitName(sec , TimeUnits.SECOND)} назад"}
    else return "сейчас"
}

enum class TimeUnits{SECOND,MINUTE,HOUR,DAY,MONTH,YEAR}
    fun TimeUnits.plural(value: Int): String{
        return "${value} ${Date().getTimeUnitName(value.toLong(),this)}"
    }



