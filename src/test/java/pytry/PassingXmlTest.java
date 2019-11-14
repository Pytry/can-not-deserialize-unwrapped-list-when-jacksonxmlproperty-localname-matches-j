package pytry;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JacksonXmlRootElement(localName = "test")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PassingXmlTest
{
  private final Map<String, Object> extraProperties = new HashMap<>();

  @JacksonXmlProperty(
      localName = "id",
      isAttribute = true)
  private String id;

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "test")
  private List<PassingXmlTest> children;

  public PassingXmlTest()
  {
  }

  public PassingXmlTest(final String id, final List<PassingXmlTest> children)
  {
    this.id = id;
    this.children = children;
  }

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

  public List<PassingXmlTest> getChildren()
  {
    return children;
  }

  public void setChildren(final List<PassingXmlTest> children)
  {
    this.children = children;
  }
}
