package hu.bme.mit.budgetanomalia.test;

import com.complexible.common.csv.CSV2RDF;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRowNumberProvider {

    @Test
    public void provideValue_correct() {
        try {
            
            CSV2RDF.RowNumberProvider rowNumberProvider = new CSV2RDF.RowNumberProvider();

            Class[] argClasses = new Class[2];
            argClasses[0] = int.class;
            argClasses[1] = String[].class;

            String[] strings = { "one", "two", "three" };
            String value = String.valueOf(0);

            @SuppressWarnings("JavaReflectionMemberAccess")
            Method method = CSV2RDF.RowNumberProvider.class.getDeclaredMethod("provideValue", argClasses);
            method.setAccessible(true);

            @SuppressWarnings("JavaReflectionInvocation")
            String result = (String) method.invoke(rowNumberProvider, 0, strings);
            method.setAccessible(false);

            assertEquals(value, result);


        } catch (Exception e) {
            //TODO valamit ide írni
        }

    }
}