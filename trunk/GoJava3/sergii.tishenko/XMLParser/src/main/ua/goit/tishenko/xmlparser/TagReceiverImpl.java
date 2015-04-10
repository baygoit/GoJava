package ua.goit.tishenko.xmlparser;

public class TagReceiverImpl implements TagReceiver {
  
  TagStack tagStack = new TagStack(); 
  

  @Override
  public void nextTag(Tag tag) throws XMLNestingException {
    
    if(tag.getType() == TagType.OPEN || tag.getType() == TagType.HEADER){
      tagStack.push(tag);
    }else if(tag.getType() == TagType.CLOSE){
       Tag lastTagOpend = tagStack.pop();
       
       if(lastTagOpend == null){
         throw new XMLNestingException("Unexpected tag close  - '" + tag.getName() + "'.");
       }else if(!lastTagOpend.getName().equals(tag.getName())){
         throw new XMLNestingException("Unexpected tag close  - '" + tag.getName() + "'. Expected: '" + lastTagOpend.getName() + "'");
       }
    }else  if(tag.getType() == TagType.SINGLE){
      tagStack.push(tag);
      tagStack.pop();
    }
    
    
  }

}
