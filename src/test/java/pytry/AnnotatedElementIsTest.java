package pytry;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JacksonXmlRootElement(localName = "test")
public class AnnotatedElementIsTest
{

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlElementWrapper(
      localName = "test",
      useWrapping = false)
  @JacksonXmlProperty(localName = "test")
  private List<AnnotatedElementIsTest> children;

  public AnnotatedElementIsTest()
  {
  }

  public AnnotatedElementIsTest(final String id, final List<AnnotatedElementIsTest> children)
  {
    this.id = id;
    this.children = children;
  }

  private final Map<String, Object> extraProperties = new HashMap<>();

  @JsonAnySetter
  public void addExtraProperty(final String key, final Object value)
  {
    extraProperties.put(key, value);
  }

  @JsonAnyGetter
  public Map<String, Object> getExtraProperties()
  {
    return extraProperties;
  }

  public String getId()
  {
    return id;
  }

  public void setId(final String id)
  {
    this.id = id;
  }

  public List<AnnotatedElementIsTest> getChildren()
  {
    return children;
  }

  public void setChildren(final List<AnnotatedElementIsTest> children)
  {
    this.children = children;
  }
}