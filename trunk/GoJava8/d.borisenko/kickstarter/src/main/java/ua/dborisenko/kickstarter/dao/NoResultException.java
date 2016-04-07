package ua.dborisenko.kickstarter.dao;

public class NoResultException extends RuntimeException {

    private static final long serialVersionUID = 8663965118637674710L;

    public NoResultException(String s) {
        super(s);
    }

}
