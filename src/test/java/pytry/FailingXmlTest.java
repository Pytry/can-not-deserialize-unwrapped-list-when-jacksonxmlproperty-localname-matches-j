package pytry;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "test")
public class FailingXmlTest
{
  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlElementWrapper(
      localName = "test",
      useWrapping = false)
  @JacksonXmlProperty(localName = "test")
  private List<FailingXmlTest> children;

  public FailingXmlTest()
  {
  }

  public FailingXmlTest(final String id, final List<FailingXmlTest> children)
  {
    this.id = id;
    this.children = children;
  }

  public String getId()
  {
    return id;
  }

  public void setId(final String id)
  {
    this.id = id;
  }

  public List<FailingXmlTest> getChildren()
  {
    return children;
  }

  public void setChildren(final List<FailingXmlTest> children)
  {
    this.children = children;
  }
}