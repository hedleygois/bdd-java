import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalculatorDef {

    private Calculator calculator;

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on() {
        calculator = new Calculator();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void adding(int arg1, int arg2) {
        calculator.push(arg1);
        calculator.push(arg2);
        calculator.push("+");
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected) {
        assertEquals(expected, calculator.value());
    }

    @Before({"~@foo"})
    public void before() {
        System.out.println("Runs before scenarios *not* tagged with @foo");
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("FIM!");
    }

    @Given("^the previous entries:$")
    public void thePreviousEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            calculator.push(entry.first);
            calculator.push(entry.second);
            calculator.push(entry.operation);
        }
    }

    public class Entry {
        Integer first;
        Integer second;
        String operation;
    }


}
