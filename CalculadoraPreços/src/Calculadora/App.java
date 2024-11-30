package Calculadora;

import javax.swing.SwingUtilities;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Janela janela = new Janela();
                	janela.criaJanela();
                }
            });
	}

}
