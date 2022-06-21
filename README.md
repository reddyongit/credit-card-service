# credit-card-service

## Spring Boot Application

####Endpoints:
<p><b>GET  http://localhost:8084/credit-card-service/swagger-ui.html</b></br>
Swagger API documentation</p>

<p><b>POST /credit-cards</b></br>
Saves the credit card details.</p>

<p><b>GET /credit-cards</b></br>
Retrieves the list of credit card details.</p>


#### For LUHN Algorithm logic please check CreditCardHelper class

#### How to test and run the application?
You need to have the following softwares in your system
<ul>
<li>Java 17</li>
<li>Maven 3.6.3</li>
</ul>

<br/>
To run the tests, go to the parent directory and run <b>mvn clean test</b>
<br/>

<br/>
To run the application, go to the parent directory and run <b>mvn spring-boot:run</b>
<br/>