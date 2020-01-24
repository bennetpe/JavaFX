package akteur;

import java.util.Arrays;

public class Actor1
{
    private Role1 role;

    private static String[] roles = new String[24];

    private int tmp = 0;

    public void action()
    {
        if (this.role != null)
        {
            this.role.play();

        }
    }

    public void addRole(Role1 role)
    {

        Actor1.roles[this.tmp] = this.role.play();
        this.tmp++;
    }

    public void clearRoles()
    {
        Arrays.fill(roles, null);

    }

    public static void main(String[] args)
    {
        Actor1 actor = new Actor1();

        actor.addRole(new HelloRole());
        actor.addRole(new ByeRole());

    }
}