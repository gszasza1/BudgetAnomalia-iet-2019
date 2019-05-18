package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import io.airlift.command.Cli;
import io.airlift.command.Help;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class TestExceptions {
    private String templateFile = "examples/cars/cars.ttl";
    private String csvFile = "examples/cars/cars.csv";
    private String outputFile = "examples/cars/output.ttl";
	private String argumentDummy = "examples/cars/cars.ttl";
	
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

	@Test
	public void testExceptionCatching(){
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setErr(new PrintStream(outContent));
		Cli.<Runnable> builder("csv2rdf").withDescription("Converts a CSV file to RDF based on a given template")
                .withDefaultCommand(CSV2RDF.class).withCommand(CSV2RDF.class).withCommand(Help.class)
                .build().parse(templateFile, csvFile, outputFile, "--separator", "asd").run();
		String str = outContent.toString();
		String[] arrOfStr = str.split(":", 2);
		assertEquals("ERROR", arrOfStr[0]);
	}
}
