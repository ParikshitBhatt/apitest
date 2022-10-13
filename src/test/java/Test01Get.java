import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

public class Test01Get {

	@Test
	void test_01() {

		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.getBody().asString());
	}

	@Test
	void test_02() {
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data.id[0]", equalTo(7));
	}
}
