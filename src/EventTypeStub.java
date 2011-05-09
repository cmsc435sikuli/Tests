import edu.umd.cs.guitar.model.data.AttributesType;
import edu.umd.cs.guitar.model.data.EventType;

public class EventTypeStub extends EventType{

	String eventId1;
	String widgetId1;
	String type1;
	boolean initial1;
	String action1;
	AttributesType optional1;
	
	public EventTypeStub(String eId, String wId, String typ, boolean init, String act, AttributesType option){
		eventId1 = eId;
		widgetId1 = wId;
		type1 = typ;
		initial1 = init;
		action1 = act;
		optional1 = option;
	}
	
	@Override
	public String getEventId(){
		return eventId1;
	}
	public void setEventId(String id){
		eventId1 = id;
	}
	public String getWidgetId(){
		return widgetId1;
	}
	public void setWidgetId(String id){
		widgetId1 = id;
	}
	public String getType(){
		return type1;
	}
	public void setType(String typ){
		type1 = typ;
	}
	public boolean isInitial(){
		return initial1;
	}
	public void setInitial(boolean init){
		initial1 = init;
	}
	public String getAction(){
		return action1;
	}
	public void setAction(String act){
		action1 = act;
	}
	public AttributesType getOptional(){
		return optional1;
	}
	
	public void setOptional(AttributesType option){
		optional1 = option;
	}
}
