package com.codeforces.yermilov.task_543a

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class Test extends Specification {

    // tag::tests[]
    def 'solve(#n, #m, #b, #mod, #a) == #expected'() {
        given:
        Main task553a = new Main()

        expect:
        task553a.solve(n, m, b, mod, a as int[]) == expected

        where:
        n | m | b | mod        | a           || expected
        3 | 3 | 3 | 100        | [ 1, 1, 1 ] || 10
        3 | 6 | 5 | 1000000007 | [ 1, 2, 3 ] || 0
        3 | 5 | 6 | 11         | [ 1, 2, 1 ] || 0
    }
    // end::tests[]
}