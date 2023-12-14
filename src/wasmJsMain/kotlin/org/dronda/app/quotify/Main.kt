package org.dronda.app.quotify

import kotlinx.browser.document
import org.w3c.dom.HTMLSelectElement
import org.w3c.dom.HTMLTextAreaElement

fun main() {
    quoteSelector!!.addEventListener("change") {
        convertStrings()
    }

    inputText!!.addEventListener("input") {
        convertStrings()
    }
}

fun convertStrings() {
    val quoteSelectorValue = quoteSelector!!.value

    val quoteType = when (quoteSelectorValue) {
        "double" -> "\""
        "single" -> "'"
        else -> ""
    }

    val styledLines = inputText!!.value.split('\n')
        .map { line -> "$quoteType$line$quoteType," }.toMutableList()

    styledLines[styledLines.lastIndex] = styledLines[styledLines.lastIndex].split(',').first()

    outputText?.value = styledLines.joinToString("\n")
}

val inputText: HTMLTextAreaElement?
    get() = document.getElementById("inputText") as? HTMLTextAreaElement
val outputText: HTMLTextAreaElement?
    get() = document.getElementById("outputText") as? HTMLTextAreaElement

val quoteSelector: HTMLSelectElement?
    get() = document.getElementById("quoteSelector") as? HTMLSelectElement
