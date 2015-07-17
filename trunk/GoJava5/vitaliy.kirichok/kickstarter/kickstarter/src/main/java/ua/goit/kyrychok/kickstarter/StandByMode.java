package ua.goit.kyrychok.kickstarter;

public enum StandByMode {
    USER {
        @Override
        public String getMessage() {
            return "Enter user name(%s): ";
        }
    },
    CARD {
        @Override
        public String getMessage() {
            return "Enter card number(%s): ";
        }
    },
    AMOUNT {
        @Override
        public String getMessage() {
            return "Enter pledge amount(%s): ";
        }
    };

    public abstract String getMessage();
}
