import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return person by id=1"

	request {
		url "/persons/1"
		method GET()
	}

	response {
		status OK()
		headers {
			contentType applicationJson()
		}
		body (
			id: 1, name: "Anakin", surname: "Skywalker", "born": "3550", "died": "3600", species: "Human"
		)
	}
}