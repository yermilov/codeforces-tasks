package com.codeforces.yermilov.task_546d

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class Test extends Specification {

    // tag::tests[]
    def 'solve(#a, #b) == #expected'() {
        given:
        Main task546d = new Main()

        expect:
        task546d.solve(a, b) == expected

        where:
        a         | b         || expected
        3         | 1         || 2
        6         | 3         || 5
        1         | 1         || 0
        5         | 5         || 0
        5_000_000 | 5_000_000 || 0
        5_000_000 | 1         || 18703742
    }
    // end::tests[]
}
