package UMLparser;

public class ParseInput {
	public static void main(String[] args) throws Exception {

        Parser pe = new Parser("/home/techmint/Downloads/MyUMLParser/src/test/java/classDiagramTest1", "/home/techmint/Downloads/MyUMLParser/src/sampleOutput/classDiagramTest1");
        pe.start();

//        SequenceParser pse = new SequenceParser("/home/techmint/Downloads/MyUMLParser/src/test/java/sequenceDiagramTest1", "Customer", "depositMoney", "/home/techmint/Downloads/MyUMLParser/src/sampleOutput/seq");
//        pse.start();
//}		
	}
}
