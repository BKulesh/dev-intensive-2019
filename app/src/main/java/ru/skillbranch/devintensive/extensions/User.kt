package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.extensions.huminizeDiff
import ru.skillbranch.devintensive.utils.Utils
import java.util.*

fun User.toUserView():UserView {

    val nickName = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName,lastName)
    val status =  if (lastVisit == null) "No ever visit" else if (isOnline) "online" else "last visit is ${lastVisit!!.huminizeDiff()}"

    return UserView(
        id,
        fullName = "$firstName $lastName",
        nickName = nickName,
        initials = initials,
        avatar = avatar,
        status = status
    )
}




