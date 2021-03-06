package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.*;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Given("I check if array is empty")
    public void iCheckIfArrayIsEmpty() {
        int[] myArr = {1, 2, 5, 6};
        int[] nullArr = null;
        System.out.println(isArrayEmpty(myArr));

    }

    boolean isArrayEmpty(int[] myArr) {

        if (myArr.length == 0 || myArr == null) {
            return true;
        } else {
            return false;
        }
    }

    @Given("I have number to check {int}")
    public void iHaveNumberToCheck(int num) {

        System.out.println(iHaveNumbers(num));
    }

    boolean iHaveNumbers(int num) {
        System.out.println("Is this integer" + " " + num + " " + "positive?");
        if (num > 0) {
            return true;
        }
        return false;
    }

    @Given("I have integer {int}")
    public void iHaveInteger(int num1) {

        for (int i = 0; i <= num1; i++) {
            System.out.print(i + " ");
        }
    }

    @Given("I have integer argument")
    public void iHaveIntegerArgument() {

        int max = 20;
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

    @Given("I have array to print even numbers")
    public void iHaveArrayToPrintEvenNumbers() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int j = 0; j <= numbers.length; j++) {
            if (j % 2 == 0) {
                System.out.print(j + " ");
            }
        }
    }

    @Given("I have array to check for another element")
    public void iHaveArrayToCheckForAnotherElement() {
        Integer[] numArr = {1, 5, 6, 7, 3, 4};
        int anotherElement = 7;
        System.out.println(isArrayHasElement(numArr, anotherElement));
    }

    boolean isArrayHasElement(Object[] numArr, Object anotherElement) {
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i].equals(anotherElement)) {
                return true;
            }
        }
        return false;

    }

    @Given("I have a function to reverses a {string}")
    public void iHaveAFunctionToReversesA(String str) {
        System.out.println("Original string:" + str);
        for (int i = str.length() - 1; i > 0; i--) {
            System.out.print(str.charAt(i));
        }
    }

    @Given("I have a {string} to reverse every {int} character")
    public void iHaveAToReverseEveryCharacter(String str, int num) {

        for (int i = str.length() - 1; i >= 0; i--) {
            if (i % num == 0) {
                System.out.print(str.charAt(i));
            }
        }
    }

    @Given("I have a string {string} to reverse")
    public void iHaveAStringToReverse(String str) {
        String[] words = str.split(" ", 0);

        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }


    }

    @Given("I have a string {string}")
    public void iHaveAString(String num) {
        String reverse = "";
        for (int i = num.length() - 1; i >= 0; i--) {
            reverse = reverse + num.charAt(i);
        }
        if (num.equalsIgnoreCase(reverse)) {
            System.out.print("true");
        } else {
            System.out.print("false");
        }

        //solution 2

        String str1 = "refer";
        System.out.println(isPalindrome(str1));

        //unit test with palindrome
        testIsPalindrome();
    }

    public void testIsPalindrome() {
        String str1 = "refer";
        assertThat(isPalindrome(str1)).isTrue();
    }

    // O(n)
    boolean isPalindrome(String word) {
        System.out.println("isPalindrome check for" + word);


        int j = 0;
        for (int i = word.length() - 1; i <= 0; i--) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            j++;
        }
        return true;
    }

    @Given("I have array with duplicates")
    public void iHaveArrayWithDuplicates() {

        int[] myArray = {11, 22, 41, 22, 44};

        for (int i = 0; i < myArray.length; i++) {
            for (int j = i + 1; j < myArray.length; j++) {
                if (myArray[j] == myArray[i]) {
                    int dupe = myArray[i];
                    System.out.println("Dupe element found in the array:" + dupe);
                }
            }
        }
    }

    @Given("I have array with max numbers")
    public void iHaveArrayWithMaxNumbers() {
        int[] myArr = {6, 7, 4, 9, 7};

        //Solution 1
        int max1 = myArr[0];
        int max2 = myArr[0];
//        for (int i = 0; i < myArr.length; i++) {
//            if (max1 < myArr[i]) {
//                max1 = myArr[i];
//            }
//            for (int j = i + 1; j < myArr.length; j++) {
//                if (max2 < myArr[j] && max2 < max1) {
//                    max2 = myArr[j];
//                }
//            }
//        }

//        System.out.println("First maximum integer in array:" + max1);
//        System.out.println("Second maximum integer in array:" + max2);

        // Second solution
        int maxVal1 = Integer.MIN_VALUE;
        int maxVal2 = Integer.MIN_VALUE;

        for (int i = 0; i < myArr.length; i++) {
            if (maxVal1 < myArr[i]) {
                maxVal2 = maxVal1;
                maxVal1 = myArr[i];
            } else if (maxVal2 < myArr[i]) {
                maxVal2 = myArr[i];
            }
        }
        System.out.println(maxVal1);
        System.out.println(maxVal2);
    }

    @Given("I have a string {string} to count characters")
    public void iHaveAStringToCountCharacters(String text) {

    }

    @Given("I have integer {int} and integer {int}")
    public void iHaveIntegerAndInteger(int num1, int num2) {

        if (num1 % 5 == 0 && num1 <= 10 && num1 > 0) {
            System.out.println(num1 + " " + "is within the range of 0 to 10");
        } else if (num1 % 5 != 0 && num1 <= 10 && num1 > 0) {
            System.out.println(num1 + " " + "not divisible by 5");
        } else if (num1 > 10 && num1 % 5 == 0 && num1 > 10) {
            System.out.println(num1 + " " + "is out of range of 0 to 10");
        } else if (num1 > 20 && num1 % 5 != 0) {
            System.out.println(num1 + " " + "is not divisible by 5 and number is out of the range 0 to 20");
        }

        if (num2 % 5 == 0 && num2 > 10 && num2 <= 20) {
            System.out.println(num2 + " " + "is within the range of 10 to 20");
        } else if (num2 % 5 != 0 && num2 > 10 && num2 <= 20) {
            System.out.println(num2 + " " + "not divisible by 5");
        } else if (num2 > 20 && num2 % 5 == 0) {
            System.out.println(num2 + " " + "is out of range of 10 to 20");
        } else if (num2 > 20 && num2 % 5 != 0) {
            System.out.println(num2 + " " + "is not divisible by 5 and number is out of the range 10 to 20");
        }
    }

    @Given("I have array with element")
    public void iHaveArrayWithElement() {

        int[] unsortedArr = {1, 2, 5, 6, 3, 1};
        int num = 2;
        System.out.println(findSum(unsortedArr, num));
    }

    boolean findSum(int[] arr, int sum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == sum) {
                    return true;
                }
            }
        }
        return false;
    }

    @Given("I have factorial function for number {int}")
    public void iHaveFactorialFunctionForNumber(int num) {
        System.out.println(factorial(num));

    }

    long factorial(long num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }

    @Given("I create Java Class")
    public void iCreateJavaClass() {
        // Creating Cat Class
        // Creating Dog Class

        // 4 principles of OOP
        //Abstraction
        //Encapsulation
        //Inheritance
        //Polymorphism

        Animal cat = new Cat("Tom");
        cat.setName("Bony");

        cat.getName();
        cat.eat("milk");
        cat.sleep();
        cat.speak();
        cat.walk();

        Animal dog = new Dog();
        dog.setName("Jerry");
        System.out.println(dog.getName());
        dog.getName();
        dog.eat("dog food");
        dog.sleep();
        dog.speak();
        dog.walk();
        ((Dog) dog).fetch("stick");
        dog.color("golden");

        Animal parrot = new Bird();
        parrot.setName("Kesha");
        parrot.color("blue and white");
        parrot.age(5);
        parrot.breed("Psittacidae");

        Animal canary = new Canary("Little one");
        canary.speak();



        List<Animal> list = new ArrayList<>();
        list.add(cat);
        list.add(dog);
        list.add(parrot);
        list.add(canary);
        printAnimalNames(list);
    }

    public void printAnimalNames(List<Animal> animals) {
        System.out.println("print method");
        for (Animal animal : animals) {
            System.out.println(animal.getName());
            animal.speak();
        }
    }

    @Given("I have a string")
    public void iHaveAString() {
        String text = "I Am Happy";
        System.out.println(reverseString(text));
        String str1 = "yppaH mA I";
        assertThat(reverseString(text)).isNotEqualTo(text);
        assertThat(reverseString(text)).isEqualTo(str1);

    }

    public String reverseString(String str) {
        String[] array = str.split(" ");
        String a = " ";
        for (int i = array.length - 1; i >= 0; i--) {
            char[] t = array[i].toCharArray();
            for (int j = t.length - 1; j >= 0; j--) {
                a = a + t[j];
            }
            a = a + " ";
        }
        return a;
    }

    @Given("I have fibonacci sequence")
    public void iHaveFibonacciSequence() {
        for (int i = 1; i <= 11; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    //solution with recursive approach
    long fib(long num) {
        if (num == 0 || num == 1) {
            return num;
        }
        return fib(num - 1) + fib(num - 2);
    }

    //  fibonacci = {1,1,2,3,5,8,13,21,34,55,89};
    long fibFor(int seq) {
        long prevFib = 0;
        long nextFib = 1;
        for (int i = 1; i < seq; i++) {
            long temp = nextFib;
            nextFib = prevFib + nextFib;
            prevFib = temp;
        }
        return nextFib;
    }

    @Given("I have function to check prime number {int}")
    public void iHaveFunctionToCheckPrimeNumber(int num) {
        System.out.println(isPrime(num));

        //print range of prime numbers
        for (int i = 1; i<= num; i++){
            if(isPrime(i)){
                System.out.print(i + " ");
            }
        }
    }

    boolean isPrime(int num) {
        //System.out.println("Check if the number " + num + " is prime");

        if (num < 2) {
            return false;
        }
        if (num % 2 == 0 && num != 2) {
            return false;
        }
        double sqrt = Math.sqrt(num);
        for (int i = 3; i <= sqrt; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}