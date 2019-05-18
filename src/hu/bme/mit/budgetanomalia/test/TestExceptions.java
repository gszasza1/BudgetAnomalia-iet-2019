package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.lang.IllegalArgumentException;

public class TestExceptions {
    private String templateFile = "examples/cars/cars.ttl";
    private String csvFile = "examples/cars/cars.csv";
    private String outputFile = "examples/cars/output.ttl";
	private String argumentDummy = "examples/cars/cars.ttl";
	private String fileDoesNotExist = "examples/cars/error.ttl";
	private String separator = "dummy";
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testTooManyArguments() throws IllegalArgumentException{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Too many arguments");
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile, csvFile, outputFile, argumentDummy).run();
    }

    @Test
    public void testNotEnoughArguments() throws IllegalArgumentException{
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Missing arguments");
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile, csvFile).run();
    }		
}
