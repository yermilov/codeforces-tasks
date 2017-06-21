package com.codeforces.yermilov.task_553a

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class Test extends Specification {

    // tag::tests[]
    def 'solve(#k, #c) == #expected'() {
        given:
        Main task553a = new Main()

        expect:
        task553a.solve(k, c as int[]) == expected

        where:
        k    | c               || expected
        3    | [2, 2, 1]       || 3
        4    | [1, 2, 3, 4]    || 1680
        1000 | [ 1000 ] * 1000 || 559191371
        1000 | [ 1 ] * 1000    || 1
    }
    // end::tests[]

    static int TEST_CASES_COUNT = 100;

    def 'combinations(#k, #n) == #expected'() {
        given:
        Main task553a = new Main()

        expect:
        task553a.combinations(k, n) == expected

        where:
        n << (1..TEST_CASES_COUNT).collect({ new Random().nextInt(10) + 1 })
        k = new Random().nextInt(n)

        expected = fact(n) / fact(k) / fact(n - k)
    }

    private int fact(int n) {
        if (n < 2) {
            return 1
        }
        (2..n).inject(1, { a, b -> a * b })
    }
}
