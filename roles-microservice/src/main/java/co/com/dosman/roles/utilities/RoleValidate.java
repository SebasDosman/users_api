package co.com.dosman.roles.utilities;


public class RoleValidate {
    public static final String ROLE_NOT_NULL = "Role can't be null";
    public static final String ID_NOT_NULL = "Role id can't be null";

    public static final String NAME_NOT_NULL = "Role name can't be null";
    public static final String NAME_NOT_BLANK = "Role name can't be blank";
    public static final String NAME_NOT_EMPTY = "Role name can't be empty";
    public static final String NAME_ALREADY_EXISTS = "Role name already exists";
    public static final String NAME_NOT_VALID = "Role name is not valid";
    public static final String NAME_REGEX = "^(ADMIN|USER|MANAGER)$";

    public static final String DESCRIPTION_NOT_NULL = "Role description can't be null";
    public static final String DESCRIPTION_NOT_BLANK = "Role description can't be blank";
    public static final String DESCRIPTION_NOT_EMPTY = "Role description can't be empty";

    public static final String ROLE_NOT_FOUND = "Role not found";
    public static final String ROLE_ELIMINATED = "Role with id %s eliminated";
    public static final String ROLE_NOT_ASSIGNED = "Role already assigned to the user";
}
