package ua.goit.model;
import java.util.ArrayList;

/* Предлагаю вынести функционал группы в отдельный интерфейс для удобства, 
 * или унаследовать его от List
 * */
public class GroupShapes implements ContainerShapes{
	private Types type = Types.GROUP;
	
	ArrayList<ContainerShapes> shapesList = new ArrayList<ContainerShapes>();
    public void add(ContainerShapes containerShapes) {
        shapesList.add(containerShapes);
    }
    
    public ContainerShapes get(int index){
    	return shapesList.get(index);
    }
    
    public int size(){
    	return shapesList.size();
    }
    
	@Override
	public Types getType() {
		return type;
	}
}
