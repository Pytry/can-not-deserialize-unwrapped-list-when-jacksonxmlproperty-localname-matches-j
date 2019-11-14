package pytry;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class test1
{
  private final Map<String, Object> extraProperties = new HashMap<>();

  @JacksonXmlProperty(isAttribute = true)
  private String id;

  @JacksonXmlElementWrapper(useWrapping = false)
  private List<test1> test;

  public test1()
  {
  }

  public test1(final String id, final List<test1> test)
  {
    this.id = id;
    this.test = test;
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

  public List<test1> getTest()
  {
    return test;
  }

  public void setTest(final List<test1> test)
  {
    this.test = test;
  }
}
