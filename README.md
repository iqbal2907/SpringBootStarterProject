
Technical Stack :
	> Springboot 2.0.3.RELEASE
	> Postgres 10
	> com.fasterxml.jackson.dataformat (In order to convert output into json or xml format using annotations provided by this package)
	> org.projectlombok (In order to generate getter/setter/tostring/hashcode etc also for generating logs)

POST REQUESTS:

1. http://localhost:9200/users/requestparam?id=1&name=requestparam
2. http://localhost:9200/users/pathvariable/2/pathvariable
3. http://localhost:9200/users/queryparam?id=3&name=queryparam
4. http://localhost:9200/users/requestbody

	json body :
	{
		"userid": 5,
		"username": "requestbody/json"
	}
	
	XML body :
	<Root>
		<UserId>6</UserId>
		<UserName>requestbody/xml</UserName>
	</Root>
	
GET REQUESTS:
	
1. http://localhost:9200/users

	Accept:application/json  OR
	Accept:text/xml