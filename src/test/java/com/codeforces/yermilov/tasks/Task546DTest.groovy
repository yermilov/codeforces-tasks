package com.codeforces.yermilov.tasks

import spock.lang.Specification

class Task546DTest extends Specification {

    def 'solve'() {
        given:
        Task546D task546D = new Task546D()

        expect:
        task546D.solve(a, b) == expected

        where:
        a | b || expected
        3 | 1 || 2
        6 | 3 || 5
    }
}
