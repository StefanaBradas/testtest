package tests;


import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePageApi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class ApiTesting {

    public String id;
    public WebDriver driver;
    public WebDriverWait driverWait;
    public BasePageApi basePageApi = new BasePageApi(driver, driverWait);


    private final String URL = "https://reqres.in";


    @Test
    public void getSingleUserTest() {
        ApiDTO response = basePageApi.getSpecificUser(7);

        Assert.assertEquals(response.getData().getFirstName(), "Michael");
        Assert.assertEquals(response.getData().getLastName(), "Lawson");
    }


    @Test
    public void getSingleUserNotFoundTest() {
        Response response = basePageApi.singleUserNotFound(23);

        Assert.assertEquals(response.getBody().asString(), "{}");

    }


    @Test
    public void getListResourceTest() {
        ResourceList response = basePageApi.listResource();

        Assert.assertEquals(response.getTotal(), "12");
        Assert.assertEquals(response.getListOfData2().size(), 6);
        Assert.assertEquals(response.getListOfData2().get(0).getName(), "cerulean");
    }


    @Test
    public void getSingleResourceTest() {
        SingleResourceDTO response = basePageApi.singleResourceDTO(2);

        Assert.assertEquals(response.getData2().getName(), "fuchsia rose");
        Assert.assertEquals(response.getData2().getId(), "2");

    }


    @Test
    public void getSingleResourceNotFoundTest() {
        Response response = basePageApi.singleResourceNotFound(23);

        Assert.assertEquals(response.body().asString(), "{}");
    }


    @Test
    public void postCreate() {

        User newUser = basePageApi.createNewUser();

        Assert.assertEquals(newUser.getName(), "morpheus");
        Assert.assertEquals(newUser.getJob(), "leader");
    }


    @Test
    public void deleteUser() {
        Response response = basePageApi.deleteUser(2);
        Assert.assertEquals(response.getBody().asString(), "");

    }


    @Test
    public void updateUserEmail() {
        ApiDTO response = basePageApi.updateUser(7, "email", "newmail@gmail.com");

        Assert.assertEquals(response.getData().getEmail(), "newmail@gmail.com");
    }


    @Test
    public void unsuccessfulLoginTest() {
        Response response = basePageApi.unsuccessfulLogIn("email: peter@klaven");

        Assert.assertEquals(response.getBody().path("error"), "Missing email or username");
    }


    // STREAM


    @Test
    public void streamTest() {
        UsersList response = basePageApi.streamTest(2);

        for (int i = 0; i < response.getListOfData().size(); i++) {
            Assert.assertTrue(response.getListOfData().get(i).getEmail().endsWith("@reqres.in"));
        }
    }


    @Test
    public void streamTest2() {

        UsersList response = basePageApi.streamTest(2);
        List<Data> emailList =
                response.getListOfData()
                        .stream()
                        .filter(data -> data.getEmail().endsWith("@reqres.in"))
                        .collect(Collectors.toList());

        Assert.assertTrue(emailList.size() == response.getListOfData().size());

        emailList.forEach(System.out::println);

    }

    @Test
    public void streamTest3() {

        UsersList response = basePageApi.streamTest(2);
        boolean allMatch = response.getListOfData()
                .stream()
                .allMatch(data -> data.getEmail().endsWith("@reqres.in"));

        Assert.assertTrue(allMatch);

    }

    @Test
    public void getOldestUserFromListOdResource() {
        ResourceList response = basePageApi.listResource();
        List<Integer> listOfYears = response.getListOfData2().stream().map(Data2::getYear).collect(Collectors.toList());
        Assert.assertEquals(basePageApi.largestNumber(listOfYears), 2005);
    }


    @Test
    public void getOldestUserFromListOdResource2() {
        ResourceList response = basePageApi.listResource();
        int a = response.getListOfData2()
                .stream().max(Comparator.comparing(Data2::getYear)).get().getYear();
        Assert.assertEquals(a, 2005);
    }


    @Test
    public void listOfUsers2() {  // vraca mi konkretan objekat Data2 preko indeksa i uporedjuje
        ResourceList response = basePageApi.listResource();
        Data2 data2 = basePageApi.getSpecificData(response.getListOfData2(), "3");

        Assert.assertEquals(data2.getColor(), "#BF1932");

    }


    @Test
    public void concreteData2Object() {  // vraca konkretan objekat preko parametra i asertuje
        ResourceList response = basePageApi.listResource();
        Data2 data2 = basePageApi.getSpecificData2(response.getListOfData2(), "id", "4");

        Assert.assertEquals(data2.getColor(), "#7BC4C4");
    }

    @Test
    public void emptyNameFieldTest() {
        ResourceList response = basePageApi.listResource();
        Assert.assertTrue(response.getListOfData2().stream().noneMatch(data2 -> data2.getName().isEmpty()));
    }


    @Test
    public void postCreateExcel() {

        UserCreate user = UserCreate.getSpecificUser(1);
        String gson =new Gson().toJson(user);
        System.out.println(gson);

        given()
                .body(gson)
                .post(URL + "/api/users/2")
                .then()
                .log().all();
    }



    @After
    public void teardown() {
        given()
                .delete(URL + "/api/users/" + id)
                .then();
    }


}