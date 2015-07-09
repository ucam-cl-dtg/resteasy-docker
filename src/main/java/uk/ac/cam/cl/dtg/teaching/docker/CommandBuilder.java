package uk.ac.cam.cl.dtg.teaching.docker;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.google.common.base.Joiner;

public class CommandBuilder {

	private List<String> commands;
	
	public CommandBuilder() {
		commands = new LinkedList<String>();
	}

	public void add(String command) {
		commands.add(command);
	}
	
	public void addAll(Collection<String> commands) {
		this.commands.addAll(commands);
	}
	
	public void addAll(String[] commands) {
		for(String s: commands) {
			this.commands.add(s);
		}
	}
	
	public String[] toCmd() {
		String toExec = Joiner.on(" && ").join(commands);
		return new String[] { "/bin/bash", "-c", toExec };
	}
}
