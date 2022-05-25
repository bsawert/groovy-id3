package com.sawert.date

import java.time.OffsetDateTime
import java.time.ZonedDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

// get current date/time
def nowLocal = OffsetDateTime.now()
def nowZulu= ZonedDateTime.now(ZoneId.of('Zulu'))

def formattedLocal = nowLocal.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
println "Local date/time: ${formattedLocal}"

def formattedZulu = nowZulu.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
println "Zulu date/time: ${formattedZulu}"