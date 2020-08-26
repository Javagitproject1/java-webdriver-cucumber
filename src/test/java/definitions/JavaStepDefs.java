package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.bcel.generic.ANEWARRAY;
import org.openqa.selenium.remote.server.handler.DeleteSession;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class JavaStepDefs {

    @Given("I say {string}")
    public void iSay(String message) {

        System.out.println(message.toLowerCase());
    }

    @Given("I say my name")
    public void iSayMyName() {

        String firstName = "Michael";
        String lastName = "Jackson";
        String favoriteColor = "green";

        System.out.println("First Name:" + firstName);
        System.out.println("Last Name:" + lastName);
        System.out.println("Favorite Color:" + favoriteColor);
        System.out.println("Greeting message:" + ("Hi, my name is" + " " + firstName + " " + lastName + " " + ", my favorite color is" + " " + favoriteColor));
        System.out.println("Upper case:" + ("Hi, my name is" + " " + firstName + " " + lastName + " " + ", my favorite color is" + " " + favoriteColor).toUpperCase());
        System.out.println("Lower case:" + ("Hi, my name is" + " " + firstName + " " + lastName + " " + ", my favorite color is" + " " + favoriteColor).toLowerCase());
        System.out.println("Length :" + ("Hi, my name is" + " " + firstName + " " + lastName + " " + ", my favorite color is" + " " + favoriteColor).length());
        System.out.println("Trim:" + ("Hi, my name is" + " " + firstName + " " + lastName + " " + ", my favorite color is" + " " + favoriteColor).trim());
        System.out.println("Empty:" + ("Hi, my name is" + " " + firstName + " " + lastName + " " + ", my favorite color is" + " " + favoriteColor).isEmpty());
        System.out.println("Get class:" + ("Hi, my name is" + " " + firstName + " " + lastName + " " + ", my favorite color is" + " " + favoriteColor).getClass());

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

        System.out.println("num1:" + (num1));
        System.out.println("num2:" + (num2));
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

        System.out.println("Favorite Color:" + (str0));
        System.out.println("Not Favorite Color:" + (notFavoriteColor));
        System.out.println("Do colors match?:" + (str0 == notFavoriteColor));
    }

    @Given("I print url for {string} page")
    public void IPrintUrlForPag(String str0) {
        if (str0.equals("google")) {
            System.out.println("google url is:" + ("https://www.google.com/"));
        } else if (str0.equals("Google")) {
            System.out.println("Google url is:" + ("https://www.google.com/"));
        } else {
            System.out.println("Sorry, not google:" + ("https://skryabin.com/webdriver/html/sample.html"));
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
        } else if (str1.equals("2")) {
            System.out.println("Tuesday");
        } else if (str1.equals("3")) {
            System.out.println("Wednesday");
        } else if (str1.equals("4")) {
            System.out.println("Thursday");
        } else if (str1.equals("5")) {
            System.out.println("Friday");
        } else if (str1.equals("6")) {
            System.out.println("Saturday");
        } else if (str1.equals("7")) {
            System.out.println("Sunday");
        } else {
            System.out.println("Please enter numbers from 1 to 7");
        }

    }

    //Using switch for conditions
    @And("I print {string} th day of the week using switch")
    public void iPrintThDayOfTheWeekUsingSwitch(String day0) {
        switch (day0) {
            case "1":
                System.out.println("Monday");
                break;
            case "2":
                System.out.println("Tuesday");
                break;
            case "3":
                System.out.println("Wednesday");
                break;
            case "4":
                System.out.println("Thursday");
                break;
            case "5":
                System.out.println("Friday");
                break;
            case "6":
                System.out.println("Saturday");
                break;
            case "7":
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Unsupported number. Use numbers from 1 to 7");
        }
    }


    @Given("I print url for {string} page using break")
    public void iPrintUrlForPageUsingBreak(String page) {

        switch (page) {
            case "Google":
                System.out.println("Google url is:" + ("https://www.google.com/"));
                break;
            case "google":
                System.out.println("google url is:" + ("https://www.google.com/"));
                break;
            case "bing":
                System.out.println("bing url is:" + ("https://bing.com"));
                break;
            default:
                System.out.println("Error:" + ("Unsupported page"));

        }
    }


    @Given("I have grocery list")
    public void iHaveGroceryList() {
        String[] groceryList = {"apple", "banana", "orange", "watermelon", "pineapple"};
        int[] numbers = {1, 3, 5, 6, 7, 8, 10};

        System.out.println(numbers);
        System.out.println(groceryList);
        System.out.println("First out of grocery list:" + groceryList[0]);
        System.out.println("Third out of grocery list:" + groceryList[2]);

        for (String str : groceryList) {
            System.out.print(str + " ");
        }

        System.out.println();

        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }


    @Given("I have list array")
    public void iHaveListArray() {

        List<Integer> numArray = Arrays.asList(1, 3, 4, 5, 6, 7, 9, 11, 12, 16, 17);
        List<String> strArray = Arrays.asList("iPhone2", "iPhone3", "iPhone3S", "iPhone4");

        List<String> str = new ArrayList<>();
        str.add("iphone1");
        str.add("iphone2");

        System.out.println(numArray);
        System.out.println(strArray);

        for (String s : str) {
            System.out.println(s);
        }
    }

    @Given("I have number {int}")
    public void iHaveNumber(int num0) {

        if (num0 % 5 == 0) {
            System.out.println("true");
        } else if (num0 % 3 == 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }


    @And("I pick every {int} rd day")
    public void iPickEveryRdDay(int str1) {
        final String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        int i = 1;
        for (String day : daysOfWeek) {
            if (i % str1 == 0) {
                System.out.println(day);
            }
            i = i + 1;
        }

        System.out.println("========================");

        for (int j = 1; j <= daysOfWeek.length; j = j + 1) {
            if (j % str1 == 0) {
                System.out.println(daysOfWeek[j - 1]);
            }
        }

        System.out.println("========================");

        for (int k = str1; k <= daysOfWeek.length; k += str1) {
            System.out.println(daysOfWeek[k - 1]);
        }

    }

    @Given("I want to print Alphabet")
    public void iWantToPrintAlphabet() {

        char c;

        for (c = 'A'; c <= 'Z'; c++) {
            System.out.print(c + " ");
        }
    }

    @Given("I have a map")
    public void iHaveAMap() {

        Map<String, String> info = new HashMap<>();

        info.put("firstName", "David");
        info.put("middleName", "George");

        System.out.println(info);
        String swapname = info.get("firstName");
        info.put("firstName", info.get("middleName"));
        info.put("middleName", swapname);
        System.out.println(info);

    }

    @Given("I create my own method")
    public void iCreateMyOwnMethod() {

        //Given a string s, remove vowels a,e,i,o,u and return the new string

        String s1 = "leetcodeisacommunityforcoders";
        String replace = s1.replaceAll("a", "");
        String s2 = replace.replaceAll("e", "");
        String s3 = s2.replaceAll("o", "");
        String s4 = s3.replaceAll("i", "");
        String s5 = s4.replaceAll("u", "");
        System.out.println(s5);

        String vowels = "aeiou";
        String news2 = vowels.replaceAll(vowels, " ");
        System.out.println(news2);

    }

    @Given("I swap {int} and {int} element in the array")
    public void iSwapAndElementInTheArray(int elm1, int elm2) {

        int[] numbers = {5, 2, 9, 7, 3};

        int temp = numbers[elm1 - 1];
        numbers[elm1 - 1] = numbers[elm2 - 1];
        numbers[elm2 - 1] = temp;

        for (int array : numbers) {
            System.out.print(array + " ");
        }
    }

    @Given("I have entered number {int}")
    public void iHaveEnteredNumber(int num1) {

        if (num1 % 3 == 0 && num1 % 4 == 0) {
            System.out.println("divisible by 3 and 4");
        } else if (num1 % 3 == 0) {
            System.out.println("divisible by 3");
        } else if (num1 % 4 == 0) {
            System.out.println("divisible by 4");
        } else {
            System.out.println("not divisible by 3 or 4");
        }
    }

    @Given("I have array")
    public void iHaveArray() {

        System.out.println("//Write a function that checks if array is empty");

        List<String> array = Arrays.asList("");
        for (String emptyarray : array) {
            if (emptyarray.isEmpty()) {
                System.out.println("Array is empty");
            } else {
                System.out.println("Arrya is not empty");
            }
        }

        System.out.println("");

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        System.out.println("//Write a function that prints all integer array");

        for (int array1 : numbers) {
            System.out.print(array1 + " ");
        }

        System.out.println("");
        System.out.println("");

        System.out.println("//Write a function that prints all even numbers from integer array");
        for (int j = 0; j <= numbers.length; j++) {
            if (j % 2 == 0) {
                System.out.print(j + " ");
            }
        }

        System.out.println("");
        System.out.println("");

        System.out.println("//Write a function that checks if array contains another element");

        List<String> fruits = Arrays.asList("apples", "bananas", "mangoes");
        if (fruits.size() > 1) {
            System.out.println("array contains another element");
        } else {
            System.out.println("there is only 1 element in the array");
        }

        System.out.println("");
        System.out.println("");

        System.out.println("//Write a function that prints all numbers from 0 to n");

        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + " ");
        }

        System.out.println("");
        System.out.println("");

        System.out.println("//Write a function that supports negative numbers");
        //function that prints only negative numbers
        List<Integer> negative = Arrays.asList(-1, -2, -3, -6, 0, 5, 2, 4, 6, -15);
        for (int i : negative) {
            if (i < 0) {
                System.out.print(i + " ");
            }
        }

        //function that checks if number is positive or not
        int num = 10;
        if (num < 0) {
            System.out.println(num + " " + "number is negative");
        } else if (num > 0) {
            System.out.println(num + " " + "number is positive");
        } else {
            System.out.println("number equals to 0");
        }

        System.out.println("");
        System.out.println("");

        System.out.println("//Write a function that accepts integer argument");

        int max = 16;
        for (int i = 1; i <= max; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.print("FizzBuzz ");
            } else if (i % 3 == 0) {
                System.out.print("Fizz ");
            } else if (i % 5 == 0) {
                System.out.print("Buzz ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}

