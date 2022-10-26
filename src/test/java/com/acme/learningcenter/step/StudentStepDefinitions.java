package com.acme.learningcenter.step;

import com.acme.learningcenter.learning.resource.CreateStudentResource;
import com.acme.learningcenter.learning.resource.StudentResource;
import io.cucumber.core.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@CucumberContextConfiguration
public class StudentStepDefinitions {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @LocalServerPort
    private int randomServerPort;

    private String endpointPath;

    private ResponseEntity<String> responseEntity;


    @Given("The Endpoint {string} is available")
    public void theEndpointIsAvailable(String endpointPath) {
        this.endpointPath = String.format(endpointPath, randomServerPort);
    }


    @When("A Post Request is sent with values {string}, {int}, {string}")
    public void aPostRequestIsSentWithValues(String name, int age, String address) {
        CreateStudentResource resource = new CreateStudentResource()
                .withName(name)
                .withAge(age)
                .withAddress(address);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<CreateStudentResource> request = new HttpEntity<>(resource, headers);
        responseEntity = testRestTemplate.postForEntity(endpointPath, request, String.class);
    }

    @Then("A Response is received with Status {int}")
    public void aResponseIsReceivedWithStatus(int expectedStatusCode) {
        int actualStatusCode = responseEntity.getStatusCodeValue();
        assertThat(expectedStatusCode).isEqualTo(actualStatusCode);
    }


    @And("An Student Resource is included in Response Body, with values {string}, {int}, {string}")
    public void anStudentResourceIsIncludedInResponseBodyWithValues(String name, int age, String address) {
        StudentResource expectedResource = new StudentResource()
                .withName(name)
                .withAge(age)
                .withAddress(address);
        String value = responseEntity.getBody();
        ObjectMapper mapper = new ObjectMapper();
        StudentResource actualResource;
        try {
            actualResource = mapper.readValue(value, StudentResource.class);

        } catch (JsonProcessingException | NullPointerException e) {
            actualResource = new StudentResource();
        }
        expectedResource.setId(actualResource.getId());
        assertThat(expectedResource).usingRecursiveComparison().isEqualTo(actualResource);
    }
}
