package UMLparser;

public class ParseInput {
	public static void main(String[] args) throws Exception {

		char [] diagram = new char[2];
        diagram[0] = args[0].toCharArray()[0];
        diagram[1] = args[0].toCharArray()[1];

        switch (diagram[1]) {
            case 'c':
                Parser c = new Parser(args[1],args[2] );
                c.start();
                break;
            case 's':
                SequenceParser s = new SequenceParser(args[1], "Main", "main", args[2]);
                s.start();
                break;
            default:
                System.out.println("Please use below format for input");
                System.out.println("For class diagram:");
                System.out.println("java -jar CMPE202jar.jar -c <absolute input path in double quotes> <absolute output path in double quotes>");
                System.out.println("For sequence diagram:");
                System.out.println("java -jar CMPE202jar.jar -s <absolute input path in double quotes> <in Class name> <out Class name> <absolute output path in double quotes>");
        }
    }	
}
