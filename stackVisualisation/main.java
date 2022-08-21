package stackVisualisation;

import java.net.CookieManager;
import java.util.Scanner;
import java.util.Stack;

public class main {
	
	private static void printInstruction() {
		System.out.println("INSTRUCTIONS:\n\n"
				+ "```````````````````````````````````\n"
				+ "Max Length of stack is 10.\n"
				+ "All commands are case sensitive.\n"
				+ "```````````````````````````````````\n\n"
				+ "COMMANDS :\n\n"
				+ "````````````````````````````````````````````````````````````````\n"
				+ "1.Push(<value>) -> It'll push a Integer value inside the stack. \n"
				+ "2.Pop() -> It'll remove an element from the top of the stack.   \n"
				+ "3.Top() -> It'll return & indicate the top element in the stack.\n"
				+ "4.isEmpty() -> It'll check whether the stack is empty or not.   \n"
				+ "5.Exit() -. It'll end the program.							   \n"
				+ "````````````````````````````````````````````````````````````````\n");
	}
	
	private static void printStack(String[] stack, String[] top) {
		System.out.println(top[9] + "|" + stack[19] + "|\n"
				+ "  +" + stack[18] + "+\n"
				+ top[8] + "|" + stack[17] + "|\n"
				+ "  +" + stack[16] + "+\n"
				+ top[7] + "|" + stack[15] + "|\n"
				+ "  +" + stack[14] + "+\n"
				+ top[6] + "|" + stack[13] + "|\n"
				+ "  +" + stack[12] + "+\n"
				+ top[5] + "|" + stack[11] + "|\n"
				+ "  +" + stack[10] + "+\n"
				+ top[4] + "|" + stack[9] + "|\n"
				+ "  +" + stack[8] + "+\n"
				+ top[3] + "|" + stack[7] + "|\n"
				+ "  +" + stack[6] + "+\n"
				+ top[2] + "|" + stack[5] + "|\n"
				+ "  +" + stack[4] + "+\n"
				+ top[1] + "|" + stack[3] + "|\n"
				+ "  +" + stack[2] + "+\n"
				+ top[0] + "|" + stack[1] + "|\n"
				+ "  +" + stack[0] + "+\n"
				);
	}
	
	private static int updateStack(Integer idx, String command, String[] stacks, String[] topSign) {
		
//		if(command.length() == 0)
			printStack(stacks, topSign);
		if(command.substring(0, 4).equals("Push")) {
			stacks[(2 * idx) + 1] = command.substring(5, command.length() - 1);
			for(int i = 0; i < (7 - command.length()); i++)
				stacks[(2 * idx) + 1] += " ";
			
			stacks[(idx + 1) * 2] = "-------";
			idx ++;
			printStack(stacks, topSign);
		}
		else if(command.equals("Pop()")){
			stacks[(idx * 2) - 1] = "       ";
			stacks[idx * 2] = "       ";
			idx --;
			printStack(stacks, topSign);
		}
		else if(command.equals("Top()")) {
			topSign[idx - 1] = "->";
			printStack(stacks, topSign);
			topSign[idx - 1] = "  ";
		}
		return idx;
	}

	public static void main(String[] args) {
		String topSign[] = {"  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  ", "  "};
		String stacks[] = {"-------", "       ", "       ", "       ", "       ","       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ", "       ","       ", "       ", "       ", "       ", "       ", "       "};
		int stackIdx = 0;
		Stack<String> stack = new Stack<>();
		String command;
		Scanner s = new Scanner(System.in);
		printInstruction();
		
		stackIdx = updateStack(stackIdx, "       ", stacks, topSign);
		
		while(true) {
			System.out.print("~$:");
			command = s.next();
			if(command.substring(0, 4).equals("Push(") || command.equals("Pop()") || command.equals("Top()")) {
//				if()
				stackIdx = updateStack(stackIdx, command, stacks, topSign);
			}
			else if(command.equals("isEmpty()")) {
				if(stackIdx == 0)
					System.out.println("True !");
				else
					System.out.println("False !");
			}
			else if(command.equals("Exit()")) {
				break;
			}
			else 
				System.out.println("Wrong Command !!");
		}
		
	}

	

}
