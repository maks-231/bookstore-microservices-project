package simulation;

import io.gatling.javaapi.core.ScenarioBuilder;
import io.gatling.javaapi.core.Simulation;
import io.gatling.javaapi.http.HttpProtocolBuilder;

import static io.gatling.javaapi.core.CoreDsl.constantUsersPerSec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.http;

public class LoadSimulation extends Simulation {
    private HttpProtocolBuilder httpProtocol = http
            .baseUrl("http://localhost:8090")
            .acceptHeader("application/json")
            .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36");;

    ScenarioBuilder scenario = scenario("Scenario").exec(http("Book").get("/book"));

    {
        setUp(scenario
                .injectOpen(constantUsersPerSec(30).during(30)))
                .protocols(httpProtocol);
    }
}
