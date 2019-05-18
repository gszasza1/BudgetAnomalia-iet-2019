package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.junit.Test;

import java.io.File;

public class TestExceptions {
    private String templateFile;
    private String csvFile;
    private String outputFile;

    private void init(){
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile, csvFile, outputFile).run();
    }

    @Test(expected = Exception.class)
    public void testTemplateError(){
        templateFile = "examples/cars/templatenotexists.ttl";
        csvFile = "examples/cars/cars.csv";
        outputFile = "examples/cars/output.ttl";
        init();
    }

    @Test(expected = Exception.class)
    public void testCSVFileError(){
        templateFile = "examples/cars/cars.ttl";
        csvFile = "examples/cars/notexists.csv";
        outputFile = "examples/cars/output.ttl";
        init();
    }
}
