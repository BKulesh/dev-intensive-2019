package ru.skillbranch.devintensive.utils

import java.lang.Character.toUpperCase

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        var firstName: String?=null
        var lastName: String?=null

        if (fullName != null) {
        if (fullName.trim()!="") {
            val parts: List<String>? = fullName?.split(" ")
            firstName = parts?.getOrNull(0)
            lastName = parts?.getOrNull(1)
        }
        }

        //return Pair(firstName,lastName)
        return firstName to lastName
    }


    fun transliteration(payload: String, devider: String = " "): String {
        var converts: String = ""
        var symbol: String = ""
        for (i in 0..payload.length - 1) {
            symbol = payload[i].toString()
            if (symbol != devider) converts=converts + transliterationSymbol(symbol)
            else converts=converts + "_"
        }
        return converts
    }

    fun transliterationSymbol(symbol: String): String {
        return when (symbol) {
            "А" -> "A"
            "а" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Б" -> "B"
            "б" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "В" -> "V"
            "в" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Г" -> "G"
            "г" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Д" -> "D"
            "д" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Е" -> "E"
            "е" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ё" -> "YO"
            "ё" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ж" -> "ZH"
            "ж" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "З" -> "Z"
            "з" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "И" -> "I"
            "и" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Й" -> "J"
            "й" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "К" -> "K"
            "к" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Л" -> "L"
            "л" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "М" -> "M"
            "м" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Н" -> "N"
            "н" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "О" -> "O"
            "о" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "П" -> "P"
            "п" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Р" -> "R"
            "р" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "С" -> "S"
            "с" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Т" -> "T"
            "т" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "У" -> "U"
            "у" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ф" -> "F"
            "ф" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Х" -> "H"
            "х" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ц" -> "C"
            "ц" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ч" -> "CH"
            "ч" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ш" -> "SH"
            "ш" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Щ" -> "SCH"
            "щ" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ь" -> "'"
            "ь" -> "'"
            "Ы" -> "Y"
            "ы" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ъ" -> "`"
            "ъ" -> "`"
            "Э" -> "E"
            "э" ->  transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Ю" -> "JU"
            "ю" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            "Я" -> "JA"
            "я" -> transliterationSymbol(symbol.toUpperCase()).toLowerCase()
            else -> symbol
        }
    }

    fun toInitials(firstName: String?, lastName: String?): String {
        var initials: String = ""
        if (firstName!!.length > 0) initials = initials + firstName!![0].toString()
        if (lastName!!.length > 0) initials = initials + lastName!![0].toString()
        return initials
    }
}