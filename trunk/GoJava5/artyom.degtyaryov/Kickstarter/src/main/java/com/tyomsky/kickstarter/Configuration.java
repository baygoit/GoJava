package com.tyomsky.kickstarter;

import com.tyomsky.kickstarter.dao.DataRegistry;
import com.tyomsky.kickstarter.ui.Output;

public class Configuration {

    public Output output;
    public DataRegistry dataProvider;

    public void setOutput(Output output) {
        this.output = output;
    }

    public void setDataProvider(DataRegistry dataProvider) {
        this.dataProvider = dataProvider;
    }

    public Output getOutput() {
        return output;
    }

    public DataRegistry getDataProvider() {
        return dataProvider;
    }

}
