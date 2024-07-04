package InterviewPrep.SeleniumMarch;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidents {
	@Test
	public void getIncidents()
	{
		//Step 1: setup endpoint
		RestAssured.baseURI="https://dev205032.service-now.com/api/now/table/incident";
		//Step 2: setup authentication
		RestAssured.authentication=RestAssured.basic("admin", "India@123");
		//Step3: Place the request
				Response response = RestAssured
				.given()
				.log().all()
				.header("Accept","application/json")
				.queryParam("sysparm_fields", "sys_id,number,short_description")
				.queryParam("sysparm_limit", "10")
				.when()
				.get();
				
				response.prettyPrint();
				
				JsonPath resp = response.jsonPath();
				
				List<String> list = resp.getList("result.short_description");
				
				System.out.println(list.size());
				
				for (String eachData : list) {
					if(eachData.equalsIgnoreCase("New employee hire")) {
						System.out.println("Match found");
					}
				}
				for (String eachData : list) {
					if(eachData.equalsIgnoreCase("INC0000024")) {
						System.out.println("Match found");
					}
				}

		
	}

}
