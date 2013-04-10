package eu.solidcraft.spock

import spock.lang.Specification
import spock.lang.Unroll

class Sample5WhereSpockRulesSpec extends Specification {

    def "maximum of two numbers"() {
        expect:
            Math.max(a, b) == max

        where:
            a | b | max
            1 | 3 | 3
            7 | 4 | 7
            0 | 0 | 0
    }

    @Unroll()
    def "maximum of two numbers with default unrolling"() {
        expect:
            Math.max(a, b) == max

        where:
            a | b || max
            1 | 3 || 3
            7 | 4 || 7
            0 | 0 || 0
    }

    @Unroll("max from #a and #b should be #max")
    def "maximum of two numbers with readable unrolling"() {
        expect:
            Math.max(a, b) == max

        where:
            a | b || max
            1 | 3 || 3
            7 | 4 || 7
            0 | 0 || 0
    }

    //show them BillerSpec

    static List<String> staticList = ['This', 'is', 'a', 'small', 'disadvantage']

    @Unroll("list contains word: #word")
    def "unfortunately, because of ASTT, where has only access to static and @Shared variables"() {
        expect:
            ['This', 'is', 'a', 'small', 'disadvantage'].contains(word)
        where:
            word << staticList
            //could be populated from db or excel: sql.rows("select * from maxdata")
    }
}
