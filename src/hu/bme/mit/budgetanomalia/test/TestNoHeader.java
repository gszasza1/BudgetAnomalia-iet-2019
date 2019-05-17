package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestNoHeader {
    private String templateFile = "examples/noheadertest/template.ttl";
    private String templateFile2 = "examples/noheadertest/template2.ttl";
    private String csvFile = "examples/noheadertest/cars.csv";
    private String outputFile = "examples/noheadertest/output.ttl";
    private String outputFile2 = "examples/noheadertest/output2.ttl";

    private void init(){
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile, csvFile, outputFile, "--no-header").run();
    }

    private void init2(){
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile2, csvFile, outputFile2, "--no-header").run();
    }

    @Test
    public void testFileIsCreated() {
        init();
        File f = new File(outputFile);
        assertNotNull(f);
    }

    @Test
    public void testFileNameIsCorrect() {
        init();
        File f = new File(outputFile);
        assertEquals(f.getName(),"output.ttl");
    }

    @Test
    public void testFileIsCreated2() {
        init2();
        File f = new File(outputFile2);
        assertNotNull(f);
    }

    @Test
    public void testFileNameIsCorrect2() {
        init2();
        File f = new File(outputFile2);
        assertEquals(f.getName(),"output2.ttl");
    }

}
