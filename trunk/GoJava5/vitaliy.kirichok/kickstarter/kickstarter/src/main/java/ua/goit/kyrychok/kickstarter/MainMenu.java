package ua.goit.kyrychok.kickstarter;

public class MainMenu {
    private Output output;
    private DaoFactoryType daoFactoryType;

    public MainMenu(Output output) {
        this.output = output;
    }

    public DaoFactoryType getDaoFactoryType() {
        return daoFactoryType;
    }

    public void run(Input input) {
        output.writeLine("Choose storage type:");
        output.writeLine("[1]. Memory storage");
        output.writeLine("[2]. XML storage");
        output.writeLine("[3]. Database storage");
        output.writeLine("Your choice(otherwise - exit):");
        read(input);
    }

    private void read(Input input) {
        String inputValue = input.getLine();
        if (inputValue.equals("1")) {
            daoFactoryType = DaoFactoryType.MEMORY;
        } else if (inputValue.equals("2")) {
            daoFactoryType = DaoFactoryType.XML;
        } else if (inputValue.equals("3")) {
            daoFactoryType = DaoFactoryType.DATABASE;
        } else {
            input.close();
        }
    }
}
