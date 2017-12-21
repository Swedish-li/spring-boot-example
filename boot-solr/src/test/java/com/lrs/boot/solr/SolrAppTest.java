package com.lrs.boot.solr;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.core.NestedCheckedException;

import static org.assertj.core.api.Assertions.assertThat;

public class SolrAppTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void main() {
        try {
            SolrApp.main(new String[0]);
        }catch (IllegalStateException ex){
            if (serverNotRunning(ex)){
                return;
            }
        }

        String out = this.outputCapture.toString();

        assertThat(out).contains("companyName='HTC Corporation'");

    }

    private boolean serverNotRunning(IllegalStateException ex) {

        @SuppressWarnings("serial")
        NestedCheckedException nested = new NestedCheckedException("failed", ex) {
        };
        Throwable root = nested.getRootCause();
        if (root.getMessage().contains("Connection refused")) {
            return true;
        }
        return false;
    }
}