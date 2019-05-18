package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.junit.Test;

import java.io.File;
import java.lang.IllegalArgumentException;

public class TestExceptions {
    private String templateFile = "examples/cars/cars.ttl";
    private String csvFile = "examples/cars/cars.csv";
    private String outputFile = "examples/cars/output.ttl";
	private String argumentDummy = "examples/cars/cars.ttl";

    @Test(expected = IllegalArgumentException.class)
    public void testTooManyArguments(){
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile, csvFile, outputFile, argumentDummy).run();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNotEnoughArguments(){
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile, csvFile).run();
    }
}
