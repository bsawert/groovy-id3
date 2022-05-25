package com.sawert.date

import groovy.json.JsonOutput

class FullAgeCalc {
    def ages = [
        1900: [years: 65, months: 0],
        1937: [years: 65, months: 0],
        1938: [years: 65, months: 2],
        1939: [years: 65, months: 4],
        1940: [years: 65, months: 6],
        1941: [years: 65, months: 8],
        1942: [years: 65, months: 10],
        1943: [years: 66, months: 0],
        1955: [years: 66, months: 2],
        1956: [years: 66, months: 4],
        1957: [years: 66, months: 6],
        1958: [years: 66, months: 8],
        1959: [years: 66, months: 10],
        1960: [years: 67, months: 0],
        2000: [years: 67, months: 0]
    ]

    def getFullAge(int birthYear) {
        ages.findAll { k, v ->
            k <= birthYear
        }.max {entry -> entry.getKey()}.value
    }

    def writeJson() {
        def json = JsonOutput.toJson([ages: ages])
        JsonOutput.prettyPrint(json)
    }

}
