package com.sawert.date

import groovy.json.JsonSlurper

import java.time.LocalDate
import java.time.Period
import java.time.temporal.ChronoUnit

// meta class to add toString
Period.metaClass.toFullString = {
    def sb = new StringBuffer()
    def units = delegate.getUnits()
    units.eachWithIndex { unit, index ->
        sb.append(delegate.get(unit))
        sb.append(' ').append(unit)
        if (index < units.size() - 1) {
            sb.append(', ')
        }
    }
    sb.toString()
}

def early = Period.of(62, 0, 0)
def full = Period.of(66, 4, 0)
def delayed = Period.of(70, 0, 0)

def dob = LocalDate.of(1956, 11, 3)
def today = LocalDate.now()

def earlyDate = early.addTo(dob)
def daysUntilEarly = ChronoUnit.DAYS.between(today, earlyDate)
println "Early retirement date: $earlyDate ($daysUntilEarly days)"

def fullDate = full.addTo(dob)
def daysUntilFull = ChronoUnit.DAYS.between(today, fullDate)
println "Full retirement date: $fullDate ($daysUntilFull days)"

def delayedDate = delayed.addTo(dob)
def daysUntilDelayed = ChronoUnit.DAYS.between(today, delayedDate)
println "Delayed retirement date: $delayedDate ($daysUntilDelayed days)"

def untilFull = Period.between(today, fullDate)
println "${untilFull.toFullString()} until full retirement"

def untilDelayed = Period.between(today, delayedDate)
println "${untilDelayed.toFullString()} until delayed retirement"

def fullAge = new FullAgeCalc().getFullAge(1956)
println "${fullAge.years} years, ${fullAge.months} months"

def jsonOut = new FullAgeCalc().writeJson()
println jsonOut
def rehydrate = new JsonSlurper().parseText(jsonOut)
println rehydrate
println rehydrate.ages.'1940'
