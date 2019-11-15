# Problems with Root Element Names
Examples that demonstrate the problem described here: https://github.com/FasterXML/jackson-dataformat-xml/issues/86

The following are 3 observations on the behavior of the jackson XmlMapper as of version 2.10.0 (and possibly earlier). 
This does NOT assert that the described and tested behaviour is correct or a bug.

1. If the localname of the root element in the actual XML is the same as any of it's children, 
then jackson cannot deserialize, regardless of how the class is annotated.

1. If the annotated class is given the same localname as any of it's fields, 
jackson will still deserialize an XML who's actual root element name does not 
match the annotated class.

1. If the XML documents main root element is different than it's children, 
then it's children may have children with a localname that is the same as their parent 
so long as the parent is not the root of the entire document.  

