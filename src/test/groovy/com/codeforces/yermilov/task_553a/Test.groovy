package com.codeforces.yermilov.task_553a

import spock.lang.Specification

class Test extends Specification {

    // tag::tests[]
    def 'solve'() {
        given:
        Main task553a = new Main()

        expect:
        task553a.solve(k, c as int[]) == expected

        where:
        k | c            || expected
        3 | [2, 2, 1]    || 3
        4 | [1, 2, 3, 4] || 1680
    }
    // end::tests[]
}
