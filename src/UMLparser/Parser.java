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

    HashMap<String, Boolean> map;
    HashMap<String, String> mapClassConn;
    String yumlCode;
    ArrayList<CompilationUnit> cuArray;
	
	public Parser(String inPath, String outFile) {
		this.inPath = inPath;
        this.outPath = outFile + ".png";
        map = new HashMap<String, Boolean>();
        mapClassConn = new HashMap<String, String>();
        yumlCode = "";
	}
	
	public void start() throws Exception {
        cuArray = getCuArray(inPath);
        buildMap(cuArray);
        for (CompilationUnit cu : cuArray)
            yumlCode += parser(cu);
        yumlCode += parseAdditions();
        yumlCode = yumlCodeUniquer(yumlCode);
        System.out.println("Unique Code: " + yumlCode);
        GenerateDiagram.generatePNG(yumlCode, outPath);
    }
	
	private String yumlCodeUniquer(String code) {
        String[] codeLines = code.split(",");
        String[] uniqueCodeLines = new LinkedHashSet<String>(
                Arrays.asList(codeLines)).toArray(new String[0]);
        String result = String.join(",", uniqueCodeLines);
        return result;
    }
	
	private String parseAdditions() {
        String result = "";
        Set<String> keys = mapClassConn.keySet(); // get all keys
        for (String i : keys) {
            String[] classes = i.split("-");
            if (map.get(classes[0]))
                result += "[<<interface>>;" + classes[0] + "]";
            else
                result += "[" + classes[0] + "]";
            result += mapClassConn.get(i); // Add connection
            if (map.get(classes[1]))
                result += "[<<interface>>;" + classes[1] + "]";
            else
                result += "[" + classes[1] + "]";
            result += ",";
        }
        return result;
    }
	
	private ArrayList<CompilationUnit> getCuArray(String inPath)
            throws Exception {
        File folder = new File(inPath);

        File[] files = folder.listFiles();
        Arrays.sort(files);

        ArrayList<CompilationUnit> cuArray = new ArrayList<CompilationUnit>();
        for (final File f : files) {
            if (f.isFile() && f.getName().endsWith(".java")) {
                FileInputStream in = new FileInputStream(f);
                CompilationUnit cu;
                try {
                    cu = JavaParser.parse(in);
                    cuArray.add(cu);
                } finally {
                    in.close();
                }
            }
        }
        return cuArray;
    }
	
	private void buildMap(ArrayList<CompilationUnit> cuArray) {
        for (CompilationUnit cu : cuArray) {
            List<TypeDeclaration<?>> cl = cu.getTypes();
            for (Node n : cl) {
                ClassOrInterfaceDeclaration coi = (ClassOrInterfaceDeclaration) n;
                map.put(coi.getNameAsString(), coi.isInterface()); // false is class,
                // true is interface
            }
        }
    }
}
