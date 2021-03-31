import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {

	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		//if (tags == null ) return null;

		Stack<HtmlTag> file = new Stack<HtmlTag>();


		//while (!tags.isEmpty()) {
		for (HtmlTag tag : tags) {
			if (tag.isOpenTag()) {
				file.push(tag);
			} 


			else {
				if (!tag.isSelfClosing()){
					if (file.isEmpty()) { // closing tag with no opening tag,  everything okay until then
						return null;
					}
					
					if(tag.matches(file.peek())) {
						file.pop();
					}

					else 
					{
						return file;
					}

				}
				
			}







		}



		return file; // this line is here only so this code will compile if you don't modify it
	}


}
