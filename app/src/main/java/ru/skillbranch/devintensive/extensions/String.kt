package ru.skillbranch.devintensive.extensions

import android.service.autofill.Validators.and

fun String.stripHtml(): String{
    var s: String=this
    s=s.replace("\"","")
    s=s.replace("\"","")
    s=s.replace("\"\"","")
    s=Regex("<.*?>").replace(s,"")
    s=Regex("(\\s){2}").replace(s,"")
    s=Regex("&.*?;").replace(s,"")
    //Regex("(\s+)").replace(s,"")
    return s
}

fun String.truncate(count:Int): String{
    var s: String=""
    var l: Int=this.length
    if ((l>0) and (count>0)) {
        s=this
        if (l>count) l = count
        s = s.substring(0, l)
        if (s[l - 1].toString() == " ") s = s.substring(0,l-1)
    } //else s="l=${l} count=${count}"
    return "${s}..."
}