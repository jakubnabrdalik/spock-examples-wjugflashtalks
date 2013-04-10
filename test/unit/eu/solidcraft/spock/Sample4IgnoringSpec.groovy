package eu.solidcraft.spock
import org.junit.Ignore
import spock.lang.IgnoreIf
import spock.lang.IgnoreRest
import spock.lang.Specification

class Sample4IgnoringSpec extends Specification {
    @Ignore("because TODO")
    def "should have ignore"() {
        expect:
           false
    }

    @IgnoreRest
    def "should ignore everything except for this"() {
        expect:
            true
    }


    def "should ignore this as well"() {
        expect:
            false
    }

    @IgnoreIf({ System.getProperty("os.name").contains("windows") })
    def "should be ignored on windows"() {
        expect:
            false
    }

//    @Requires({ System.getProperty("os.name").contains("linux") })
//    def "should be not ignored on linux"() {
//        expect:
//            true
//    }

}
