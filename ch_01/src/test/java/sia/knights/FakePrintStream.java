package sia.knights;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: FreedomLy
 * Date: 2018-05-30 9:23
 * Description:
 */
public class FakePrintStream extends PrintStream {

    private static StringBuffer printBuffer = new StringBuffer();

    public FakePrintStream() {
        super(new ByteArrayOutputStream());
    }

    @Override
    public void println(String string) {
        printBuffer.append(string).append('\n');
    }

    public String getPrintedString() {
        return printBuffer.toString();
    }

    public void clear() {
        printBuffer = new StringBuffer();
    }
}
