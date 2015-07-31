package ua.goit.kyrychok.kickstarter;

public class Bootstrap {
    public static void main(String[] args) {
        KickStarter kickStarter = new KickStarter(new ConsoleOutput());
        kickStarter.run();
    }
}
