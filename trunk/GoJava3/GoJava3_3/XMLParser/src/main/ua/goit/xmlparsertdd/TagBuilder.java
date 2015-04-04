package ua.goit.xmlparsertdd;

public class TagBuilder {
  private TagType type;
  private StringBuilder name = new StringBuilder();

  public TagType getType() {
    return type;
  }

  public void setType(TagType type) {
    this.type = type;
  }

  public String getName() {
    return name.toString();
  }

  public void buildName(char c) {
    name.append(c);
  }

  public Tag getTag() {
    return new Tag(type, name.toString());
  }
}
