%dw 1.0
%output application/java
---
{
	flightOperator: payload.airline,
	toAirport: payload.destination,
	fromAirport: "MUA",
	dateOfTravel: now as :string {format: "dd/MM/YYYY HH:mm:SS"}
} as :object {class: "java.util.HashMap"}