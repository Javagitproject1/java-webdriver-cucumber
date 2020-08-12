package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.remote.server.handler.DeleteSession;

import java.util.Arrays;

public class JavaStepDefs {

    @Given("I say {string}")
    public void iSay(String message) {
        System.out.println(message);
    }

    @Given("I say my name")
    public void iSayMyName (){

        String firstName = "Michael";
        String lastName = "Jackson";
        String favoriteColor = "green";

        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("Favorite Color:" + favoriteColor);
        System.out.println("Greeting message:"+ ("Hi, my name is" + " " + firstName +" "+lastName + " " + ", my favorite color is" + " " +favoriteColor));
        System.out.println("Upper case:"+ ("Hi, my name is" + " " + firstName +" "+lastName + " " + ", my favorite color is" + " " +favoriteColor).toUpperCase());
        System.out.println("Lower case:"+ ("Hi, my name is" + " " + firstName +" "+lastName + " " + ", my favorite color is" + " " +favoriteColor).toLowerCase());
        System.out.println("Length :"+ ("Hi, my name is" + " " + firstName +" "+lastName + " " + ", my favorite color is" + " " +favoriteColor).length());
        System.out.println("Trim:"+ ("Hi, my name is" + " " + firstName +" "+lastName + " " + ", my favorite color is" + " " +favoriteColor).trim());
        System.out.println("Empty:"+ ("Hi, my name is" + " " + firstName +" "+lastName + " " + ", my favorite color is" + " " +favoriteColor).isEmpty());
        System.out.println("Get class:"+ ("Hi, my name is" + " " + firstName +" "+lastName + " " + ", my favorite color is" + " " +favoriteColor).getClass());

    }

    @Given("I have {string} and {string}")
    public void iHaveAnd(String var0, String var1) {

        System.out.println("var1:" + (var0));
        System.out.println("var2:" + (var1));
        System.out.println("upper case:" + (var0 + " " + var1).toUpperCase());
        System.out.println("lower case:" + (var1 + " " + var1).toLowerCase());
        System.out.println("Length:" + (var1 + " " + var1).length());
        System.out.println("Equal:" + var0.equals(var1));
        System.out.println("Equal if ignoring case:" + var0.equalsIgnoreCase(var1));
        System.out.println("contains:" + var0.contains(var1));

    }

    //Values for variables assigned in step definition
    @Given("I have num1 {int} and num2 {int}")
    public void iHaveNum1AndNum2(int num1, int num2) {

        System.out.println("num1:"+ (num1));
        System.out.println("num2:"+ (num2));
        System.out.println("sum: " + (num1 + (num2)));
        System.out.println("difference:" + (num1 - (num2)));
        System.out.println("quotient:" + (num1 % (num2)));
        System.out.println("product:" + (num1 * (num2)));

        //Values for variables assigned inside the Java code

        //int num3 = 20;
        //int num4 = 33;

        //System.out.println("num1:" +(num3));
        //System.out.println("num1:" +(num4));
        //System.out.println("sum:"+ (num3 + (num4)));
        //System.out.println("difference:"+ (num3 - (num4)));
        //System.out.println("quotient:"+ (num3 % (num4)));
        //System.out.println("product:"+ (num3 * (num4)));

    }


    @Given("I like {string} color")
    public void iLikeColor(String str0) {
        String notFavoriteColor = "Black";

        System.out.println("Favorite Color:" +(str0));
        System.out.println("Not Favorite Color:" + (notFavoriteColor));
        System.out.println("Do colors match?:" + (str0==notFavoriteColor));
    }

    @Given("I print url for {string} page")
    public void IPrintUrlForPag(String str0) {
        if (str0.equals("google")){
            System.out.println("google url is:" + ("https://www.google.com/"));
        } else if (str0.equals("Google")){
            System.out.println("Google url is:" + ("https://www.google.com/"));
        } else {
            System.out.println ("Sorry, not google:" + ("https://skryabin.com/webdriver/html/sample.html"));
        }


    }


    @And("I print if number {int} is positive")
    public void iPrintIfNumberIsPositive(int int0) {

        if (int0 > 0) {
            System.out.println("positive");
        } else {
            System.out.println("negative");
        }

    }

    //using If/else for conditions
    @And("I print {string} th day of the week")
    public void iPrintThDayOfTheWeek(String str1) {

        if (str1.equals("1")) {
            System.out.println("Monday");
        } else if (str1.equals("2")){
            System.out.println("Tuesday");
        } else if (str1.equals("3")){
            System.out.println("Wednesday");
        } else  if (str1.equals("4")){
            System.out.println("Thursday");
        } else if (str1.equals("5")){
            System.out.println("Friday");
        } else if (str1.equals("6")){
            System.out.println("Saturday");
        } else if (str1.equals("7")){
            System.out.println("Sunday");
        } else{
            System.out.println("Please enter numbers from 1 to 7");
        }
    }

    //Using switch for conditions
    @And("I print {string} th day of the week using switch")
    public void iPrintThDayOfTheWeekUsingSwitch(String day0) {
        switch(day0){
            case "1":
                System.out.println("Monday");
                break;
            case"2":
                System.out.println("Tuesday");
                break;
            case "3":
                System.out.println("Wednesday");
                break;
            case"4":
                System.out.println("Thursday");
                break;
            case"5":
                System.out.println("Friday");
                break;
            case"6":
                System.out.println("Saturday");
                break;
            case"7":
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Unsupported number. Use numbers from 1 to 7");
        }
    }


    @Given("I print url for {string} page using break")
    public void iPrintUrlForPageUsingBreak(String page) {

        switch(page){
            case "Google":
                System.out.println("Google url is:" + ("https://www.google.com/"));
                break;
            case "google":
                System.out.println("google url is:" + ("https://www.google.com/"));
                break;
            case "bing":
                System.out.println("bing url is:" + ("https://bing.com") );
                break;
            default:
                System.out.println("Error:" + ("Unsupported page"));

        }
    }


    @Given("I have grocery list")
    public void iHaveGroceryList() {
        String[] groceryList = {"apple", "banana", "orange", "watermelon", "pineapple"};

        System.out.println();
        System.out.println("First out of grocery list:" + groceryList[0]);
        System.out.println("Third out of grocery list:" + groceryList[2]);
        }


}

