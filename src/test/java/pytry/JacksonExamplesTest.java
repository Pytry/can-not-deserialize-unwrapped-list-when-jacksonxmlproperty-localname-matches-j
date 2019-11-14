/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pytry;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class JacksonExamplesTest
{
  private final ObjectMapper mapper = XmlMapper.xmlBuilder()
      .enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
      .enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT)
      .serializationInclusion(NON_NULL)
      .build();

  //@formatter:off
  private static final String example_1_xml =
      "<test1 id=\"0\">" +
          "<test id=\"0.1\">" +
              "<test id=\"0.1.1\"/>" +
          "</test>" +
          "<test id=\"0.2\"/>" +
          "<test id=\"0.3\">" +
              "<test id=\"0.3.1\"/>" +
          "</test>" +
      "</test1>";

  private static final String example_2_xml =
      "<PassingXmlTest id=\"0\">" +
          "<test id=\"0.1\"/>" +
          "<test id=\"0.2\">" +
              "<test id=\"0.2.1\"/>" +
          "</test>" +
      "</PassingXmlTest>";

  private static final String example_3_xml =
      "<test id=\"0\">" +
          "<test id=\"0.1\"/>" +
          "<test id=\"0.2\">" +
              "<test id=\"0.2.1\"/>" +
          "</test>" +
       "</test>";

  private static final String example_4_xml =
      "<test id=\"0\">" +
          "<test id=\"0.1\"/>" +
          "<test id=\"0.2\">" +
              "<test id=\"0.2.1\"/>" +
          "</test>" +
      "</test>";
  //@formatter:on

  @Test
  void missingLocalNameInJacksonXmlElementWrapperShouldCauseJsonMappingException() throws Exception
  {
    assertThrows(JsonMappingException.class, () -> mapper.readValue(example_1_xml, FailingXmlTest.class));
  }

  @Test
  void example_2_xml_should_succeed() throws Exception
  {
    assertDoesNotThrow(() -> mapper.readValue(example_2_xml, FailingXmlTest.class));
  }

  @Test
  void example_3_xml_should_fail() throws Exception
  {
    assertThrows(JsonMappingException.class, () -> mapper.readValue(example_3_xml, FailingXmlTest.class));
  }

  @Test
  void example_4_xml_should_succeed() throws Exception
  {
    assertDoesNotThrow(() -> mapper.readValue(example_4_xml, PassingXmlTest.class));
  }

  @Test
  void example_1_xml_ShouldDeserializeToPassingXmlTest() throws Exception
  {
    final PassingXmlTest passingXmlTest = mapper.readValue(example_1_xml, PassingXmlTest.class);
    //ROOT//
    assertEquals(0, passingXmlTest.getExtraProperties().size());
    assertEquals("0", passingXmlTest.getId());
    assertEquals(3, passingXmlTest.getChildren().size());
    //CHILD 1//
    assertEquals(0, passingXmlTest.getChildren().get(0).getExtraProperties().size());
    assertEquals("0.1", passingXmlTest.getChildren().get(0).getId());
    assertEquals(1, passingXmlTest.getChildren().get(0).getChildren().size());
    assertEquals(0, passingXmlTest.getChildren().get(0).getChildren().get(0).getExtraProperties().size());
    assertEquals("0.1.1", passingXmlTest.getChildren().get(0).getChildren().get(0).getId());
    //CHILD 2//
    assertEquals(0, passingXmlTest.getChildren().get(1).getExtraProperties().size());
    assertEquals("0.2", passingXmlTest.getChildren().get(1).getId());
    assertNull(passingXmlTest.getChildren().get(1).getChildren());
    //CHILD 3//
    assertEquals("0.3", passingXmlTest.getChildren().get(2).getId());
    assertEquals(1, passingXmlTest.getChildren().get(2).getChildren().size());
    assertEquals("0.3.1", passingXmlTest.getChildren().get(2).getChildren().get(0).getId());
    assertNull(passingXmlTest.getChildren().get(2).getChildren().get(0).getChildren());
    assertEquals(example_1_xml, mapper.writeValueAsString(passingXmlTest));
  }

  @Test
  void example_1_xml_ShouldDeserializeTo_test1() throws Exception
  {
    final test1 passingXmlTest = mapper.readValue(example_1_xml, test1.class);
    //ROOT//
    assertEquals(0, passingXmlTest.getExtraProperties().size());
    assertEquals("0", passingXmlTest.getId());
    assertEquals(3, passingXmlTest.getTest().size());
    //CHILD 1//
    assertEquals(0, passingXmlTest.getTest().get(0).getExtraProperties().size());
    assertEquals("0.1", passingXmlTest.getTest().get(0).getId());
    assertEquals(1, passingXmlTest.getTest().get(0).getTest().size());
    assertEquals(0, passingXmlTest.getTest().get(0).getTest().get(0).getExtraProperties().size());
    assertEquals("0.1.1", passingXmlTest.getTest().get(0).getTest().get(0).getId());
    //CHILD 2//
    assertEquals(0, passingXmlTest.getTest().get(1).getExtraProperties().size());
    assertEquals("0.2", passingXmlTest.getTest().get(1).getId());
    assertNull(passingXmlTest.getTest().get(1).getTest());
    //CHILD 3//
    assertEquals("0.3", passingXmlTest.getTest().get(2).getId());
    assertEquals(1, passingXmlTest.getTest().get(2).getTest().size());
    assertEquals("0.3.1", passingXmlTest.getTest().get(2).getTest().get(0).getId());
    assertNull(passingXmlTest.getTest().get(2).getTest().get(0).getTest());
    assertEquals(example_1_xml, mapper.writeValueAsString(passingXmlTest));
  }

  @Test
  void example_2_xml_ShouldDeserializeToPassingXmlTest() throws Exception
  {
    final PassingXmlTest passingXmlTest = mapper.readValue(example_2_xml, PassingXmlTest.class);
    assertEquals("0", passingXmlTest.getId());
    assertEquals(2, passingXmlTest.getChildren().size());
    assertEquals("0.1", passingXmlTest.getChildren().get(0).getId());
    assertNull(passingXmlTest.getChildren().get(0).getChildren());
    assertEquals("0.2", passingXmlTest.getChildren().get(1).getId());
    assertEquals(1, passingXmlTest.getChildren().get(1).getChildren().size());
    assertEquals("0.2.1", passingXmlTest.getChildren().get(1).getChildren().get(0).getId());
    assertNull(passingXmlTest.getChildren().get(1).getChildren().get(0).getChildren());
    assertEquals(example_2_xml, mapper.writeValueAsString(passingXmlTest));
  }

  @Test
  void aManuallyCreatedPassingXmlTestShouldSerializeToBeEqualTo_example_2_xml() throws Exception
  {
    assertEquals(example_2_xml,
                 mapper.writeValueAsString(
                     new PassingXmlTest("0", List.of(
                         new PassingXmlTest("0.1", null),
                         new PassingXmlTest("0.2", List.of(
                             new PassingXmlTest("0.2.1", null)))))));
  }
}
