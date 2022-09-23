package io.pragra.framework;

import io.pragra.framework.data.DataReader;
import io.pragra.framework.keywords.KeyWordLoop;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class Runner {
    @Test
    public void testName() throws InterruptedException {
        List<List<Object>> tcs = DataReader.getKeyWordsFromSheet();

        Iterator<List<Object>> iterator = tcs.iterator();

        while (iterator.hasNext()) {
            List<Object> tc = iterator.next();

            Iterator<Object> tcIterator = tc.iterator();
            while (tcIterator.hasNext()) {
                KeyWordLoop.runKeyWord(((String) tcIterator.next()));
            }

        }


    }
}
