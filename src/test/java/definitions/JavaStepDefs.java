package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.remote.server.handler.DeleteSession;

import java.util.Arrays;

public class JavaStepDefs {

    @Given("I say {string}")
    public void iSay(String message) {

        String firstName="David";
        String lastName="Bowie.";
        String color="Green";
        String greeting = "Hi, my name is";
        String greeting1 = "My favorite color is";
        String fulltext= greeting + " "+ firstName + " " + lastName + " " + greeting1 + " " +color;

        System.out.println(message);
        System.out.println("greeting: " + (fulltext));
        System.out.println("greeting length:" + (fulltext.length()));
        System.out.println("upper case:" + (firstName.toUpperCase()));
        System.out.println("lower case:" + (lastName.toLowerCase()));

    }


    @And("You say {string}")
    public void youSay(String message) {

        System.out.println(message);
    }

    @Given("I say firstName {string}")
    public void iSayFirstName(String str0) {

        System.out.println("First Name:" + str0);
    }

    @And("I say lastName {string}")
    public void iSayLastName(String str1) {

        System.out.println("Last Name:" +str1);
    }

    @And("I say favoriteColor {string}")
    public void iSayFavoriteColor(String str2) {

        System.out.println("Favorite Color:" +str2);
    }

    @Then("I concatenate {string} with {string}")
    public void iConcatenateWith(String str3, String str4) {

        System.out.println("city1: " + str3);
        System.out.println("city2: " + str4);

        System.out.println("upper case: " + str3.toUpperCase());
        System.out.println("lower case: " + str4.toLowerCase());

        System.out.println("city1 length: " + str3.length());
        System.out.println("city2 length: " + str4.length());

        System.out.println("city1 = city2:" + (str3.equals(str4)));
        System.out.println("city1 contains city2:" + (str3.contains(str4)));
        System.out.println ("concatenation:" + (str3 + " " + (str4)));

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

        //int num1 = 20;
        //int num2 = 33;

        //System.out.println("num1:" +(num1));
        //System.out.println("num1:" +(num2));
        //System.out.println("sum:"+ (num1 + (num2)));
        //System.out.println("difference:"+ (num1 - (num2)));
        //System.out.println("quotient:"+ (num1 % (num2)));
        //System.out.println("product:"+ (num1 * (num2)));

    }


    @Given("I like {string} color")
    public void iLikeColor(String str0) {
        String notFavoriteColor = "Black";

        System.out.println("Favorite Color:" +(str0));
        System.out.println("Not Favorite Color:" + (notFavoriteColor));
        System.out.println("Do colors equal?:" + (str0.equals(notFavoriteColor)));
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

    //using If/else for confiditions
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
        String [] groceryList = {"apple","banana","orange","watermelon","pineapple"};

        System.out.println();
        System.out.println(groceryList [0]);
        System.out.println(groceryList[2]);

    }


}

