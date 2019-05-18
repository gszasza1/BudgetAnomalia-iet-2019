package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import java.io.File;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMainFunction {
    private String templateFile = "examples/cars/template.ttl";
    private String csvFile = "examples/cars/cars.csv";
    private String outputFile = "examples/cars/new_output.ttl";
	
    @Test
    public void testMainFunction(){
		CSV2RDF program = new CSV2RDF();
		String[] args = {templateFile, csvFile, outputFile};
		program.main(args);
		File testFile = new File("examples/cars/new_output.ttl");
		boolean fileExists = testFile.exists();
		assertEquals(fileExists, true);
    }
}
