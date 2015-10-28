package ua.goit.kyrychok.installer;

public class AbstractStep {
    protected InstallerOutput output;
    protected PostgreSQLProvider dataSource;

    public AbstractStep(InstallerOutput output, PostgreSQLProvider dataSource) {
        this.output = output;
        this.dataSource = dataSource;
    }
}
