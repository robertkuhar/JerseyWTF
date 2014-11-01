package jerseywtf;

import static org.testng.AssertJUnit.assertEquals;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTestNg;
import org.testng.annotations.Test;

public class JerseyTestNGTest extends JerseyTestNg.ContainerPerClassTest {

  @Path("hello")
  public static class HelloResource {
    @GET
    public String getHello() {
      return "Hello World!";
    }
  }

  @Override
  protected Application configure() {
    return new ResourceConfig(HelloResource.class);
  }
  
  private void doIt() {
    final String hello = target("hello").request().get(String.class);
    assertEquals("Hello World!", hello);
  }

  @Test
  public void notIntegrationTest() {
    doIt();
  }

  @Test(groups = {"integration"})
  public void integrationTest() {
    doIt();
  }

}
