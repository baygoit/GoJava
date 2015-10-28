package ua.goit.kyrychok.kickstarter;

import ua.goit.kyrychok.kickstarter.dao.database.datasource_provider.OraDbDataSourceProvider;
import ua.goit.kyrychok.kickstarter.dao.database.datasource_provider.PsqlDataSourceProvider;
import ua.goit.kyrychok.kickstarter.dao.database.factory.OraSqlProviderFactory;
import ua.goit.kyrychok.kickstarter.dao.database.factory.PsqlSqlProviderFactory;
import ua.goit.kyrychok.kickstarter.dao.factory.AbstractDaoFactory;
import ua.goit.kyrychok.kickstarter.dao.factory.DbDaoFactory;
import ua.goit.kyrychok.kickstarter.dao.factory.MemoryDaoFactory;
import ua.goit.kyrychok.kickstarter.dao.factory.XmlDaoFactory;
import ua.goit.kyrychok.kickstarter.dao.memory.MemoryStorage;
import ua.goit.kyrychok.kickstarter.dao.xml.XmlStorage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class KickStarter {
    private Output output;

    public KickStarter(Output output) {
        this.output = output;
    }

    private AbstractDaoFactory createOraDbDaoFactory(Properties properties) {
        OraDbDataSourceProvider oraDbDataSourceProvider = new OraDbDataSourceProvider();
        try {
            oraDbDataSourceProvider.init(properties.getProperty("ora.url"),
                    properties.getProperty("ora.user"), properties.getProperty("ora.password"));
        } catch (SQLException e) {
            throw new RuntimeException("Can't initialize database", e);
        }
        return new DbDaoFactory(oraDbDataSourceProvider, new OraSqlProviderFactory());
    }

    private AbstractDaoFactory createPsqlDbDaoFactory(Properties properties) {
        PsqlDataSourceProvider dataSourceProvider = new PsqlDataSourceProvider();
        try {
            dataSourceProvider.init(properties.getProperty("psql.url"),
                    properties.getProperty("psql.user"), properties.getProperty("psql.password"));
        } catch (SQLException e) {
            throw new RuntimeException("Can't initialize database", e);
        }
        return new DbDaoFactory(dataSourceProvider, new PsqlSqlProviderFactory());
    }

    private AbstractDaoFactory createDbDaoFactory(DaoFactoryType factoryType, Properties properties) {
        AbstractDaoFactory result = null;
        switch (factoryType) {
            case DATABASE:
                result = createOraDbDaoFactory(properties);
                break;
            case POSTGRESQL:
                result = createPsqlDbDaoFactory(properties);
                break;
        }
        return result;
    }

    private AbstractDaoFactory createMemoryDaoFactory() {
        MemoryStorage storage = new MemoryStorage();
        storage.init();
        return new MemoryDaoFactory(storage);
    }

    private AbstractDaoFactory createXmlDaoFactory(String dataFileName, String schemaFileName) {
        File dataFile = new File(dataFileName);
        File schemaFile = new File(schemaFileName);

        XmlStorage storage = new XmlStorage(dataFile, schemaFile);
        storage.init();
        return new XmlDaoFactory(storage);
    }

    private AbstractDaoFactory getCurrentFactory(DaoFactoryType factoryType) {
        switch (factoryType) {
            case MEMORY:
                return createMemoryDaoFactory();
            case XML:
                return createXmlDaoFactory("src/main/resources/data.xml", "src/main/resources/schema.xsd");
            case DATABASE:
            case POSTGRESQL:
                Properties properties = new Properties();
                String fileName = "src/main/resources/conf/database.properties";
                try {
                    properties.load(new FileInputStream(fileName));
                } catch (IOException e) {
                    throw new RuntimeException("Can't read properties file " + fileName, e);
                }
                return createDbDaoFactory(factoryType, properties);
            default:
                throw new RuntimeException("Not implemented factory " + factoryType);
        }
    }

    public void run() {
        MainMenu mainMenu = new MainMenu(output);
        Input input = new Input();
        mainMenu.run(input);
        DaoFactoryType daoFactoryType = mainMenu.getDaoFactoryType();
        if (daoFactoryType != null) {
            AbstractDaoFactory factory = getCurrentFactory(daoFactoryType);
            Dispatcher dispatcher = new Dispatcher();
            dispatcher.init(factory, output);
            dispatcher.onStart();
            input.addListener(dispatcher);
            input.listenInput();
        }
    }
}
