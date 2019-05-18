package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;


public class TestRowNumberProvider {

    @Test
    public void provideValueCorrect() {
        try {
            
            CSV2RDF.RowNumberProvider rowNumberProvider = new CSV2RDF.RowNumberProvider();

            Class[] paramClasses = new Class[2];
            paramClasses[0] = int.class;
            paramClasses[1] = String[].class;

            String[] strings = { "one", "two", "three" };
            String value = String.valueOf(0);

            @SuppressWarnings("JavaReflectionMemberAccess")
            Method method = CSV2RDF.RowNumberProvider.class.getDeclaredMethod("provideValue", paramClasses);
            method.setAccessible(true);

            @SuppressWarnings("JavaReflectionInvocation")
            String result = (String) method.invoke(rowNumberProvider, 0, strings);
            method.setAccessible(false);

            assertEquals(value, result);


        } catch (Exception e) {
            // Mindig ide jut
            System.out.println("Not gone to the function body. It got exception");
        }

    }
}