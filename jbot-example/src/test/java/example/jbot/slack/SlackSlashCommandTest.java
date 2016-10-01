package example.jbot.slack;

import example.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ramswaroop
 * @version 05/08/2016
 */
// @RunWith(SpringRunner.class)
// @WebMvcTest(SlackSlashCommand.class)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class SlackSlashCommandTest {
    public class Config {

    }
    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    SlackSlashCommand slackSlashCommand;

    // @Autowired
    private MockMvc mvc;

    @Before
    public void init() {
        // http://solutiondesign.com/blog/-/blogs/spring-and-mockito-happy-together
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void onReceiveSlashCommand_When_IncorrectToken_Should_ReturnSorryRichMessage() throws Exception {
        this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        mvc.perform(MockMvcRequestBuilders.post("/slash-command?" +
                        "token={token}&" +
                        "team_id={team_id}&" +
                        "team_domain={team_domain}&" +
                        "channel_id={channel_id}&" +
                        "channel_name={channel_name}&" +
                        "user_id={user_id}&" +
                        "user_name={user_name}&" +
                        "command={command}&" +
                        "text={text}&" +
                        "response_url={response_url}&",
                "incorrect_token",
                "any_team_id",
                "any_domain",
                "UHASHB8JB",
                "test-channel",
                "UNJSD9OKM",
                "uname",
                "/command",
                "help",
                "http://example.com")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.text").value("Sorry! You're not lucky enough to use our slack command."));
    }
}
