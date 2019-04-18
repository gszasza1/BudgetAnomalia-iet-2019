package test;


import com.complexible.common.csv.CSV2RDF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CSV2RDFTest {

    private CSV2RDF test;

    @BeforeEach
    public void init(){
        this.test = new CSV2RDF();
    }
    @Test
    public void toChar_test(){
        //Arrange

        //Act
        char temp=test.toChar("a");

        //Assert
        assertEquals('a', temp);

    }
}
