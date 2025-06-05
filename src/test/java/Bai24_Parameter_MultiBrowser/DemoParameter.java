package Bai24_Parameter_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameter {

    @Test
    @Parameters({"n1", "n2"})
    public void sum(int n1, int n2){
        int totalSum = n1 + n2;
        System.out.println("Total sum is: " + totalSum);

        // Kiểm tra kiểu dữ liệu
        System.out.println("Type of n1: " + ((Object) n1).getClass().getSimpleName());
        System.out.println("Type of n2: " + ((Object) n2).getClass().getSimpleName());
    }


    @Test
    @Parameters({"email", "password"})
    public void login(String email, String password){
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

        System.out.println("Type of email: " + ((Object) email).getClass().getSimpleName());
        System.out.println("Type of password: " + ((Object) password).getClass().getSimpleName());

    }
}
