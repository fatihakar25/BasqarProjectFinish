package StepDefinitions;

import Pages.GradeLevels_Content;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class US_05_GradeLevelsSteps {

    GradeLevels_Content gradeLevelsContent=new GradeLevels_Content();

    @When("^click on button with button at Grade Level$")
    public void clickOnButtonWithButtonAtGradeLevel(DataTable elements) {
        List<String> elementsToClick=elements.asList(String.class);

        for (int i = 0; i < elementsToClick.size(); i++) {

            gradeLevelsContent.findAndClickElement(elementsToClick.get(i));

        }
    }

    @Then("^Send text with inputbox at Grade Level$")
    public void sendTextWithInputboxAtGradeLevel(DataTable elements) {

        List<List<String>> elementsNameAndValue=elements.asLists(String.class);

        for (int i = 0; i < elementsNameAndValue.size(); i++) {
            gradeLevelsContent.findElementAndSendKeys(elementsNameAndValue.get(i).get(0), elementsNameAndValue.get(i).get(1));
        }

    }

    @Then("^User should see \"([^\"]*)\" at Grade Level$")
    public void userShouldSeeAtGradeLevel(String alertBox) {
        gradeLevelsContent.verifyElementContainsText(gradeLevelsContent.message, "succes");
    }

    @And("^User edit the \"([^\"]*)\" to \"([^\"]*)\" at GradeLevelName$")
    public void userEditTheToAtGradeLevelName(String degisecek, String degismis) {
        gradeLevelsContent.editAndDeleteFunction(degisecek,"edit");
        gradeLevelsContent.findElementAndSendKeys("nameBox",degismis);
    }

    @And("^User delete the \"([^\"]*)\" at Grade Level$")
    public void userDeleteTheAtGradeLevel(String nameOfElementToDelete) {
        gradeLevelsContent.editAndDeleteFunction(nameOfElementToDelete,"delete");
    }
}
