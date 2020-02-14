import org.springframework.cloud.contract.spec.Contract

Contract.make {
	description "should return a meaningful error message for person with id=1000"

	request {
		url "/persons/1000"
		method GET()
	}

	response {
		status NOT_FOUND()
	}
}