package ua.goit.kyrychok.installer;

public class ConsoleInstallerOutput implements InstallerOutput {
    @Override
    public void writeLine(String string) {
        System.out.println(string);
    }
}
