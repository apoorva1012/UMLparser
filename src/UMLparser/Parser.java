package UMLparser;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.String;

import com.github.javaparser.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.printer.PrettyPrinterConfiguration;
import net.sourceforge.plantuml.StringUtils;

public class Parser {
	private String inPath;
	private String outPath;
	
	public Parser(String inPath, String outPath) {
		this.inPath = inPath;
        this.outPath = outFile + ".png";
        map = new HashMap<String, Boolean>();
        mapClassConn = new HashMap<String, String>();
        yumlCode = "";
	}
	
	
	
}
