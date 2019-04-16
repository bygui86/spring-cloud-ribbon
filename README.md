
# Spring Cloud Ribbon sample projects

## Sub-projects

* [ribbon-client](ribbon-client)
* [ribbon-server](ribbon-server)

---

## Run

1. Start first server
	```shell
	cd ribbon-server/
	mvnw clean spring-boot:run
	```

2. Start second server
	```shell
	cd ribbon-server/
	mvnw clean spring-boot:run -Dspring.profiles.active=second
	```

3. Start client
	```shell
	cd ribbon-client/
	mvnw clean spring-boot:run
	```

4. Make some requests to look at different results
	```shell
	curl http://localhost:8080/greeting
	```

---

## Links

* https://www.baeldung.com/spring-cloud-rest-client-with-netflix-ribbon
* https://spring.io/guides/gs/client-side-load-balancing/
* https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-ribbon.html
