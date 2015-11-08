package ua.goit.shapeserializer;

import java.util.HashMap;
import java.util.Map;

import ua.goit.shapeserializer.basicobjects.Shape;

public abstract class SerializeClassHolder {
   static Map <Object, Object> serialMap;
    
   static {
	serialMap = new HashMap <Object, Object>();
    }

   public static ShapeSerializer  getSerializator(Shape arg) {
       
       Object  clazz = serialMap.get(arg.getClass());
       
       if (clazz == null){
	   throw new UnsupportedOperationException();
       }
       
	try {
	    return (ShapeSerializer) ((Class<? extends Shape>) clazz).newInstance(); 
	    
	} catch (InstantiationException | IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

   
   public String serialize(Shape arg) {
      
       Object clazz;
       clazz = serialMap.get(arg.getClass());
       ShapeSerializer shapeSerializer = null;
       if (clazz == null){
	   throw new UnsupportedOperationException("Unknown serializator for " + arg.toString());
       }
       try {
	    shapeSerializer =  (ShapeSerializer) ((Class<? extends Shape>) clazz).newInstance();
	} catch (InstantiationException | IllegalAccessException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return shapeSerializer.serialize(arg);
    }




public String innerSerialize(Shape arg) {
    
	return this.serialize(arg);
 

}
}