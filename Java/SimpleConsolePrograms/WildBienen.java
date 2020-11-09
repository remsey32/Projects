import acm.program.ConsoleProgram;
import tree.BinaryNode;
import tree.BinaryTree;

/**
 * Bienen-Arten-Suchmaschine
 * 
 * @author Sven Remy
 */

public class WildBienen extends ConsoleProgram {
	public static void main(String[] args) {
		new WildBienen().start(args);
	}
	
	private BinaryTree<String> entscheidungen;
	
	public void run() {
		setFont("Times New Roman-bold-30");
		
		createDecisionTree();
		beeWalkThrough();
	}
	
	private void createDecisionTree() {
		 BinaryNode<String> eins = new BinaryNode<String>("Dichte Haarbüschel (Sammelbürsten) am 3. Beinpaar oder auf der Unterseite des Hinterleibes.");
		 BinaryNode<String> zwei = new BinaryNode<String>("Sammelbürste an den Beinen, 14 bis 15mm, stark behaart (grau-schwarz-braun.");
		 BinaryNode<String> sieben = new BinaryNode<String>("Körperlänge 4 bis 9mm, schwarz mit heller Gesichtszeichnung und hellen Flecken an Brust und Beinen.");
		 eins.setLeft(zwei);
		 eins.setRight(sieben);
		 
		 BinaryNode<String> pelzbiene = new BinaryNode<String>("Pelzbiene");
		 BinaryNode<String> drei = new BinaryNode<String>("Beobachtet im Frühjahr (ab März / April)");
		 zwei.setLeft(pelzbiene);
		 zwei.setRight(drei);
		 
		 BinaryNode<String> vier = new BinaryNode<String>("Körperlänge 8 bis 14mm, stark behaart");
		 BinaryNode<String> fünf = new BinaryNode<String>("Körperlänge 7 bis 17mm, stark behaart, meist bräunlich");
		 drei.setLeft(vier);
		 drei.setRight(fünf);
		 
		 BinaryNode<String> mauerbiene = new BinaryNode<String>("Mauerbiene");
		 BinaryNode<String> scherenbiene = new BinaryNode<String>("Scherenbiene");
		 vier.setLeft(mauerbiene);
		 vier.setRight(scherenbiene);
		 
		 BinaryNode<String> blattschneiderbiene = new BinaryNode<String>("Blattschneiderbiene");
		 BinaryNode<String> sechs = new BinaryNode<String>("Körperlänge 11 bis 18mm, deutlich gelb-schwarz gezeichnet");
		 fünf.setLeft(blattschneiderbiene);
		 fünf.setRight(sechs);
		 
		 BinaryNode<String> wollbiene = new BinaryNode<String>("Wollbiene");
		 BinaryNode<String> löcherbiene = new BinaryNode<String>("Löcherbiene");
		 sechs.setLeft(wollbiene);
		 sechs.setRight(löcherbiene);
		 
		 BinaryNode<String> maskenbiene = new BinaryNode<String>("Maskenbiene");
		 BinaryNode<String> solitäreWespe = new BinaryNode<String>("Solitäre Wespe");
		 sieben.setLeft(maskenbiene);
		 sieben.setRight(solitäreWespe);
		 
		 entscheidungen = new BinaryTree<String>(eins);
	}
	
	private void beeWalkThrough() {
		println("Wilkommen bei der Bienen-Arten-Suchmaschine");
		println("Lese dir die vorgegebene Information durch und antworte mit ja, wenn die Information zutrifft, oder mit nein wenn nicht.");
		BinaryNode<String> currentNode = (BinaryNode<String>) entscheidungen.root();
		while (currentNode.isInternal()) {

			String answer = readLine(currentNode.getElement() + "\n(ja/nein): ");
			if (answer.equals("ja")) {
				currentNode = currentNode.getLeft();
			} else {
				currentNode = currentNode.getRight();
			}
		}
		println(currentNode.getElement());
	}
}