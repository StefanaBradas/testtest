package pages;

import helper.RequestBody;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.*;

import java.util.List;
import java.util.Objects;

import static helper.ConstantsApi.API_URL;
import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;


public class BasePageApi extends BasePage {


    public BasePageApi(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public UsersList streamTest(int id) {
        UsersList response = given().get(API_URL + "/api/users?page=" + id).then().log().all().extract().as(UsersList.class);

        return response;

    }


    public ApiDTO getSpecificUser(int requestId) {
        return
                given().
                        get(API_URL + "/api/users/" + requestId)
                        .then()
                        .statusCode(SC_OK)
                        .log().all()
                        .extract().as(ApiDTO.class);
    }

    public ApiDTO updateUser(int requestId, String par, String value) {

        return
                given()
                        .body("{" + par + ": " + value + "}")
                        .patch(API_URL + "/api/users/" + requestId)
                        .then()
                        .log().all()
                        .extract().as(ApiDTO.class);
    }


    public User createNewUser() {

        RequestBody requestBody = new RequestBody();
        RequestBody.putValues("Mike", "driver");
        String json = requestBody.makeJsonFormat();

        System.out.println(json);

        return
                given()
                        .body(json)
                        .post("https://reqres.in" + "/api/users")
                        .then().statusCode(SC_CREATED)
                        .log().all()
                        .extract().as(User.class);

    }


    public Response deleteUser(int id) {
        return
                given()
                        .delete(API_URL + "/api/users/" + id)
                        .then()
                        .statusCode(SC_NO_CONTENT)
                        .extract().response();

    }


    public Response unsuccessfulLogIn(String email) {
        return
                given()
                        .body("{email: " + email + "}")
                        .post(API_URL + "/api/login")
                        .then()
                        .statusCode(SC_BAD_REQUEST)
                        .extract().response();

    }


    public Response singleUserNotFound(int id) {
        return
                given().
                        get(API_URL + "/api/users/" + id).
                        then()
                        .statusCode(SC_NOT_FOUND)
                        .body("isEmpty()", Matchers.is(true))
                        .extract().response();
    }

    public ResourceList listResource() {
        return
                given()
                        .get(API_URL + "/api/unknown")
                        .then()
                        .statusCode(SC_OK)
                        .log().all()
                        .extract().as(ResourceList.class);

    }


    public SingleResourceDTO singleResourceDTO(int id) {

        return
                given()
                        .get(API_URL + "/api/unknown/" + id)
                        .then()
                        .statusCode(SC_OK)
                        .log().all()
                        .extract().as(SingleResourceDTO.class);

    }

    public Response singleResourceNotFound(int id) {

        return
                given()
                        .get(API_URL + "/api/unknown/" + id)
                        .then().statusCode(SC_NOT_FOUND)
                        .log().all()
                        .extract().response();
    }

    public int largestNumber(List<Integer> list) {   //    20   10   5   8   15

        int num = list.get(0);

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i) > num) {
                num = list.get(i);
            }

        }
        return num;

    }


    public Data2 getSpecificData (List <Data2> listOfData2, String value) {

        Data2 data = listOfData2.get(1);

        for (int i = 0; i < listOfData2.size(); i++) {
            if (Objects.equals(listOfData2.get(i).getId(), value)) {
                data = listOfData2.get(i);
            }
        }
        return data;
    }


    public Data2 getSpecificData2 (List <Data2> listOfData2, String parameter, String value) {

        Data2 data = listOfData2.get(1);

        for (int i = 0; i < listOfData2.size(); i++) {

            switch (parameter) {
                case "id":
                    if (listOfData2.get(i).getId().equals(value)) {
                        data = listOfData2.get(i);
                        break;
                    }
                case "name":
                    if (listOfData2.get(i).getName().equals(value)) {
                        data = listOfData2.get(i);
                        break;
                    }
            }
            
        }
        return data;
    }





}



