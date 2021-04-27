package client;

/*
 *		DISTRIBUTED SYSTEMS PROJECT - HDSDEV_SEP 
 *		@AUTHOR X20144148
 */	

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

// redirect console output to text area
// needed for client, server and bidirectional streaming
public class MyOutputStream extends OutputStream {
	private JTextArea textArea;
	
	public MyOutputStream(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void write(int b) throws IOException {
		textArea.append(String.valueOf((char)b));
		textArea.setCaretPosition(textArea.getDocument().getLength());
		
		
		
	}

}
