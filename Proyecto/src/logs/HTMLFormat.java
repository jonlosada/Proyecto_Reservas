package logs;

import java.sql.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class HTMLFormat extends Formatter{

	@Override
	public String format(LogRecord record) {
		// TODO Auto-generated method stub
		return "<P>\n" + record.getMessage() + " " + (new Date(record.getMillis())).toString() + "\n</P>\n";
	}
	
	@Override
	public String getHead(Handler h) {
		// TODO Auto-generated method stub
		return "<HTML>\n <BODY> \n";
	}

	
	@Override
	public String getTail(Handler h) {
		// TODO Auto-generated method stub
		return " </BODY>\n</HTML>\n";

	}


}
