package org.example.steps;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.example.common.JsonHelper;
import org.example.common.TestContext;
import org.example.common.client.PostServiceClient;
import org.example.common.client.UserServiceClient;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractStepsDefinitions {

    private static final ThreadLocal<TestContext> context = ThreadLocal.withInitial(TestContext::new);

    @Autowired
    protected WireMockServer wiremockServer;

    @Autowired
    protected JsonHelper jsonHelper;

    @Autowired
    protected PostServiceClient postServiceClient;

    @Autowired
    protected UserServiceClient userServiceClient;

    public TestContext getContext() {
        return context.get();
    }
}
