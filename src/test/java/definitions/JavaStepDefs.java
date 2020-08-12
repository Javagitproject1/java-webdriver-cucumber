package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class JavaStepDefs {

    @Given("I say {string}")
    public void iSay(String message) {

        String firstName="David";
        String lastName="Gherkin.";
        String color="Green";
        String greeting = "Hi, my name is";
        String greeting1 = "My favorite color is";
        String fulltext= greeting + " "+ firstName + " " + lastName + " " + greeting1 + " " +color;

        System.out.println(fulltext);
        System.out.println(firstName.getClass());
        System.out.println(firstName.length()+lastName.length()+color.length());
        System.out.println(firstName.toUpperCase());
        System.out.println(firstName.trim());
        System.out.println(message);
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

        System.out.println("str3: " + str3);
        System.out.println("str4: " + str4);

        System.out.println("str3: "+ str3.toUpperCase());
        System.out.println("str4: "+ str4.toUpperCase());

        System.out.println("str3: "+ str3.length());
        System.out.println("str4: "+ str4.length());

        System.out.println(str3.equals(str4));
        System.out.print(str3.equalsIgnoreCase(str4));
        System.out.print(str3.contains(str4));

    }

}
