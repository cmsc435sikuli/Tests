import java.util.List;

import edu.umd.cs.guitar.model.data.AttributesType;
import edu.umd.cs.guitar.model.data.GUIStructure;
import edu.umd.cs.guitar.model.data.StepType;



public class StepTypeStub extends StepType{

	static final long serialVersionUID = 1;
	String eventId;
	boolean reachingStep;
	List<String> parameter;
	AttributesType optional;
	GUIStructure guiStructure;

	public StepTypeStub(String id, boolean reachStep, List<String> param, AttributesType option, GUIStructure gui){
		this.eventId = id;
		this.reachingStep = reachStep;
		this.parameter = param;
		this.optional = option;
		this.guiStructure = gui;
	}
	
	@Override
	public String getEventId(){
		return eventId;
	}

	public void setEventId(String event){
		eventId = event;
	}

	public boolean isReachingStep(){
		return reachingStep;
	}

	public void setReachingStep(boolean reach){
		reachingStep = reach;
	}

	public List<String> getParameter(){
		return parameter;
	}

	public AttributesType getOptional(){
		return optional;
	}

	public void setOptional(AttributesType option){
		optional = option;
	}

	public GUIStructure getGUIStructure(){
		return guiStructure;
	}

	public void setGUIStructure(GUIStructure gui){
		guiStructure = gui;
	}

	public void setParameter(List<String> param){
		parameter = param;
	}
}
