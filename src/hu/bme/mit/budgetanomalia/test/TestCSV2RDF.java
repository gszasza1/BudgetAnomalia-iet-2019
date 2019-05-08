package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

public class TestCSV2RDF {

    private String templateFile = "examples/selftest2/desk_template.ttl";
    private String csvFile = "examples/selftest2/desk.csv";
    private String outputFile = "examples/selftest2/output.ttl";


    private void init(){
       Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile,csvFile,outputFile).run();
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
}
