# spring-boot-docker-stockapi
A small application to call the Yahoo Finance API and print the trendiest stocks on the command line. Containerized by Docker. In order to run the app on your machine, you will need to have a Yahoo Finance API key.

To run the app in IntelliJ IDEA, where it was written, do the following:

1. Clone the repo and open the project in IntelliJ IDEA.
2. Set up a maven run configuration for the project. 
3. On line one of the application.properties file under *src/main/resources*, replace the "your-yahoo-finance-api-key-goes-here" text with your Yahoo Finance API key.
4. Run!
