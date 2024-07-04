package InterviewPrep.SeleniumMarch;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.containsString;

public class CreateNewIncident {
	
	@DataProvider
	public String[] fetchFile() {
		String[] filePath = new String[2];
		filePath[0] ="./data/data1.json";
		filePath[1] ="./data/data2.json";
		return filePath;

	}
	@Test(dataProvider="fetchFile")
	public void CreateIncident(String filePath)
	{
	//Step 1: setup endpoint
	RestAssured.baseURI="https://dev205032.service-now.com/api/now/table/incident";
	//Step 2: setup authentication
	RestAssured.authentication=RestAssured.basic("admin", "India@123");
	File file=new File(filePath);
	//Step3: Place the request
	Response response = RestAssured
	.given()
	.log().all()
	.header("Content-Type","application/json")
	.queryParam("sysparm_fields", "sys_id,number,short_description")
	.body(file)
	.when()
	.post()
	.then()
	.assertThat()
	.statusCode(201)
	.body("result.short_description", containsString("Created using file"))
	.extract().response();
	response.prettyPrint();
//	JsonPath resp = response.jsonPath();
//	String desc = resp.get("result.short_description");
//	if(desc.contains("Created using file"))
//	{
//		System.out.println("Pass");
//	}
//	else
//	{
//		System.out.println("Fail");
//	}
	
	
	}
}
