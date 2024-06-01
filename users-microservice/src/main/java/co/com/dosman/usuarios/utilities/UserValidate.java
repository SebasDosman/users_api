package co.com.dosman.usuarios.utilities;


public class UserValidate {
    public static final String USER_NOT_NULL = "User can't be null";
    public static final String ID_NOT_NULL = "User id can't be null";

    public static final String NAME_NOT_NULL = "User name can't be null";
    public static final String NAME_NOT_BLANK = "User name can't be blank";
    public static final String NAME_NOT_EMPTY = "User name can't be empty";
    public static final String NAME_NOT_VALID = "User name is not valid";
    public static final String NAME_REGEX = "^[\\p{L}\\s'-]+$";

    public static final String LAST_NAME_NOT_NULL = "User last name can't be null";
    public static final String LAST_NAME_NOT_BLANK = "User last name can't be blank";
    public static final String LAST_NAME_NOT_EMPTY = "User last name can't be empty";
    public static final String LAST_NAME_NOT_VALID = "User last name is not valid";
    public static final String LAST_NAME_REGEX = "^[\\p{L}\\s'-]+$";

    public static final String AGE_NOT_NULL = "User age can't be null";
    public static final String AGE_TOO_YOUNG = "User age can't be less than 1";
    public static final String AGE_TOO_OLD = "User age can't be greater than 100";

    public static final String EMAIL_NOT_NULL = "User email can't be null";
    public static final String EMAIL_NOT_BLANK = "User email can't be blank";
    public static final String EMAIL_NOT_EMPTY = "User email can't be empty";
    public static final String EMAIL_ALREADY_EXISTS = "User email already exists";
    public static final String EMAIL_NOT_VALID = "User email is not valid";
    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    public static final String PASSWORD_NOT_NULL = "User password can't be null";
    public static final String PASSWORD_NOT_BLANK = "User password can't be blank";
    public static final String PASSWORD_NOT_EMPTY = "User password can't be empty";
    public static final String PASSWORD_NOT_VALID = "User password is not valid";
    public static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-zA-Z]).{8,}$";

    public static final String USER_NOT_FOUND = "User not found";
    public static final String USER_ELIMINATED = "User with id %s eliminated";
}
