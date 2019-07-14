package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

data class User (
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar:String?,
    var rating:Int=0,
    var respect: Int =0,
    var lastVisit: Date? =null,
    var isOnline:Boolean=false

    ) {

    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {

        println(
            "it's Alive!!! \n" +
                    "${if (lastName === "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName !!!"}\n "
        )
    }

    fun printMe() = println(
        """
    id: $id
    firstName: $firstName
    lastName: $lastName
    avatar: $avatar
    rating: $rating
    respect: $respect
    lastVisit: $lastVisit
    isOnline: $lastVisit
        """
    )

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId++
            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(id = "$lastId", firstName = firstName, lastName = lastName)
        }


        fun build(id: String,firstName: String,lastName: String,avatar: String,rating: Int,respect: Int,lastVisit: Date,
                       isOnline: Boolean): User {
            return User(id,firstName,lastName,avatar,rating, respect, lastVisit,isOnline)
        }

    }



}