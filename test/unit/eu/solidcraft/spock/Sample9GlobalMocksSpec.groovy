package eu.solidcraft.spock

import spock.lang.Ignore
import spock.lang.Specification

class Sample9GlobalMocksSpec extends Specification {
    BigDecimal price = new BigDecimal(200)
    String productName = "Sanity injectors"

    def "mocking static methods? No problem!"() {
        given:
            GroovyMock(ZeroTaxCalculator, global: true)
            Transaction transaction = new Transaction()
            ZeroTaxCalculator.iSuckAndIWriteStaticMethods() >> "nope"
        when:
            String outcome = transaction.doISuck()
        then:
            outcome == "nope"
    }

    @Ignore
    def "all your instances are should belong to us"() {
        given:
            TaxCalculator calculator = GroovyMock(ZeroTaxCalculator, global: true)
            Transaction transaction = new Transaction()
            calculator.calculateTax(_) >> BigDecimal.TEN
        when:
            transaction.perform(productName, price)
        then:
            transaction.tax == BigDecimal.TEN
    }
}
