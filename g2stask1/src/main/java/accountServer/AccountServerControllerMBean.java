package accountServer;

@SuppressWarnings("UnusedDeclaration")
public interface AccountServerControllerMBean {
    public int getUsersLimit();

    public void setUsersLimit(int usersLimit);
}