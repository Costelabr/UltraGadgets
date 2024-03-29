package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.ChatColor;

	public class UtilJsonBuilder {
		 
	 
	    public enum ClickAction {
	        RUN_COMMAND, SUGGEST_COMMAND, OPEN_URL
	    }
	    public enum HoverAction {
	        SHOW_TEXT
	    }
	 
	    private List<String> extras = new ArrayList<String>();
	 
	    public UtilJsonBuilder(String... text) {
	        for(String extra : text)
	            parse(extra);
	    }
	 
	    public UtilJsonBuilder parse(String text) {
	           String regex = "[&�]{1}([a-fA-Fl-oL-O0-9]){1}";
	           text = text.replaceAll(regex, "�$1");
	           if(!Pattern.compile(regex).matcher(text).find()) {
	              withText(text);
	              return this;
	           }
	           String[] words = text.split(regex);
	 
	           int index = words[0].length();
	           for(String word : words) {
	               try {
	                   if(index != words[0].length())
	               withText(word).withColor("�"+text.charAt(index - 1));
	               } catch(Exception e){}
	               index += word.length() + 2;
	           }
	           return this;
	       }
	 
	    public UtilJsonBuilder withText(String text) {
	        extras.add("{text:\"" + text + "\"}");
	        return this;
	    }
	 
	    public UtilJsonBuilder withColor(ChatColor color) {
	        String c = color.name().toLowerCase();
	        addSegment(color.isColor() ? "color:" + c : c + ":true");
	        return this;
	    }
	 
	    public UtilJsonBuilder withColor(String color) {
	        while(color.length() != 1) color = color.substring(1).trim();
	        withColor(ChatColor.getByChar(color));
	        return this;
	    }
	 
	    public UtilJsonBuilder withClickEvent(ClickAction action, String value) {
	        addSegment("clickEvent:{action:" + action.toString().toLowerCase()
	                + ",value:\"" + value + "\"}");
	        return this;
	    }
	 
	    public UtilJsonBuilder withHoverEvent(HoverAction action, String value) {
	        addSegment("hoverEvent:{action:" + action.toString().toLowerCase()
	                + ",value:\"" + value + "\"}");
	        return this;
	    }
	 
	    private void addSegment(String segment) {
	        String lastText = extras.get(extras.size() - 1);
	        lastText = lastText.substring(0, lastText.length() - 1)
	                + ","+segment+"}";
	        extras.remove(extras.size() - 1);
	        extras.add(lastText);
	    }
	 
	    public String toString() {
	        if(extras.size() <= 1) return extras.size() == 0 ? "{text:\"\"}" : extras.get(0);
	        String text = extras.get(0).substring(0, extras.get(0).length() - 1) + ",extra:[";
	        extras.remove(0);;
	        for (String extra : extras)
	            text = text + extra + ",";
	        text = text.substring(0, text.length() - 1) + "]}";
	        return text;
	    }

}
