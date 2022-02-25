import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.*;

/**
 * Commands to run tests:
 * javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTest.java
 * java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTest
 */
public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test 
    public void firstTest() throws IOException { 
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }

    @Test 
    public void secondTest() throws IOException { 
        Path fileName = Path.of("new-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/week/week3/"), links);
    }

    @Test 
    public void thirdTest() throws IOException { 
        Path fileName = Path.of("no-paren.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of(), links);
    }

    @Test 
    public void fourthTest() throws IOException { 
        Path fileName = Path.of("first-line.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(List.of("https://help.com"), links);
    }

    @Test
    public void snippet1Test() throws IOException { 
        Path fileName = Path.of("Snippet1.md"); 
        String contents = Files.readString(fileName); 
        ArrayList<String> links = MarkdownParse.getLinks(contents); 
        assertEquals(List.of("google.com", "ucsd.edu"), links); 
    }

    @Test
    public void snippet2Test() throws IOException { 
        Path fileName = Path.of("Snippet2.md"); 
        String contents = Files.readString(fileName); 
        ArrayList<String> links = MarkdownParse.getLinks(contents); 
        assertEquals(List.of("a.com(())", "example.com"), links); 
    } 

    @Test
    public void snippet3Test() throws IOException { 
        Path fileName = Path.of("Snippet3.md"); 
        String contents = Files.readString(fileName); 
        ArrayList<String> links = MarkdownParse.getLinks(contents); 
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links); 
    } 
}