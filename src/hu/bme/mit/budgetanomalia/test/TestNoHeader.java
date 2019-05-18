package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestNoHeader {
    private String templateFile = "examples/noheadertest/template.ttl";
    private String templateFile2 = "examples/noheadertest/template2.ttl";
    private String csvFile = "examples/noheadertest/cars.csv";
    private String outputFile = "examples/noheadertest/output.ttl";
    private String outputFile2 = "examples/noheadertest/output2.ttl";

    private void init(String template, String output){
        Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(template, csvFile, output, "--no-header").run();
    }

    //Check if file is generated correctly when the csv file has no header and the template uses number variables.
    @Test
    public void testFileGeneratedCorrectly() {
        init(templateFile, outputFile);
        boolean containsCarLabel = false;
        boolean containsOfferComment = false;
        boolean containsPriceValue = false;
        String line;
        File f = new File(outputFile);
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if (line.contains("rdfs:label \"Ford E350 (1997)\""))
                    containsCarLabel = true;
                if (line.contains("rdfs:comment \"ac, abs, moon\""))
                    containsOfferComment = true;
                if (line.contains("gr:hasCurrencyValue \"3000.00\"^^xsd:float"))
                    containsPriceValue = true;
            }
        } catch (FileNotFoundException e){
            fail();
        }
        boolean result = containsCarLabel && containsOfferComment && containsPriceValue;
        assertTrue(result);
    }

    //Check if file is generated correctly when the csv file has no header and the template uses letter variables.
    @Test
    public void testFileGeneratedCorrectly2() {
        init(templateFile2, outputFile2);
        boolean containsCarLabel = false;
        boolean containsOfferComment = false;
        boolean containsPriceValue = false;
        String line;
        File f = new File(outputFile2);
        try {
            Scanner sc = new Scanner(f);
            while(sc.hasNextLine()){
                line = sc.nextLine();
                if (line.contains("rdfs:label \"Ford E350 (1997)\""))
                    containsCarLabel = true;
                if (line.contains("rdfs:comment \"ac, abs, moon\""))
                    containsOfferComment = true;
                if (line.contains("gr:hasCurrencyValue \"3000.00\"^^xsd:float"))
                    containsPriceValue = true;
            }
        } catch (FileNotFoundException e){
            fail();
        }
        boolean result = containsCarLabel && containsOfferComment && containsPriceValue;
        assertTrue(result);
    }

}
