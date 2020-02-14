package com.msg.group.com.msg;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.msg.group.BaseTestClass;
import io.restassured.module.mockmvc.specification.MockMvcRequestSpecification;
import io.restassured.response.ResponseOptions;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import static com.toomuchcoding.jsonassert.JsonAssertion.assertThatJson;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.springframework.cloud.contract.verifier.assertion.SpringCloudContractAssertions.assertThat;
import static org.springframework.cloud.contract.verifier.util.ContractVerifierUtil.*;

public class GroupTest extends BaseTestClass {

	@Test
	public void validate_shouldReturnPersonWithIdOne() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.get("/persons/1");

		// then:
			assertThat(response.statusCode()).isEqualTo(200);
			assertThat(response.header("Content-Type")).matches("application/json.*");
		// and:
			DocumentContext parsedJson = JsonPath.parse(response.getBody().asString());
			assertThatJson(parsedJson).field("['died']").isEqualTo("3600");
			assertThatJson(parsedJson).field("['id']").isEqualTo(1);
			assertThatJson(parsedJson).field("['name']").isEqualTo("Anakin");
			assertThatJson(parsedJson).field("['surname']").isEqualTo("Skywalker");
			assertThatJson(parsedJson).field("['born']").isEqualTo("3550");
			assertThatJson(parsedJson).field("['species']").isEqualTo("Human");
	}

	@Test
	public void validate_shouldReturnWithErrorMessageIfWrongPersonId() throws Exception {
		// given:
			MockMvcRequestSpecification request = given();

		// when:
			ResponseOptions response = given().spec(request)
					.get("/persons/1000");

		// then:
			assertThat(response.statusCode()).isEqualTo(404);
	}

}
