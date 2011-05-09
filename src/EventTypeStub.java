import edu.umd.cs.guitar.model.data.AttributesType;
import edu.umd.cs.guitar.model.data.EventType;

public class EventTypeStub extends EventType{

	String eventId;
	String widgetId;
	String type;
	boolean initial;
	String action;
	AttributesType optional;
	
	public EventTypeStub(String eId, String wId, String typ, boolean init, String act, AttributesType option){
		this.eventId = eId;
		this.widgetId = wId;
		this.type = typ;
		this.initial = init;
		this.action = act;
		this.optional = option;
	}
	
	@Override
	public String getEventId(){
		return eventId;
	}
	public void setEventId(String id){
		eventId = id;
	}
	public String getWidgetId(){
		return widgetId;
	}
	public void setWidgetId(String id){
		widgetId = id;
	}
	public String getType(){
		return type;
	}
	public void setType(String typ){
		type = typ;
	}
	public boolean isInitial(){
		return initial;
	}
	public void setInitial(boolean init){
		initial = init;
	}
	public String getAction(){
		return action;
	}
	public void setAction(String act){
		action = act;
	}
	public AttributesType getOptional(){
		return optional;
	}
	
	public void setOptional(AttributesType option){
		optional = option;
	}
}
