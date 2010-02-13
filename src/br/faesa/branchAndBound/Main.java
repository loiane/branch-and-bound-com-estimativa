package br.faesa.branchAndBound;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;

import br.faesa.gui.Window;

/**
 * Classe principal, que executa o programa
 * 
 * @author Ivan Nicoli
 * @author Loiane Groner
 * @author Luiz Gustavo Ribeiro Pagani
 *
 */
public class Main {

	public static void main(String[] args) 
	{
		try {
			UIManager.setLookAndFeel(new PlasticXPLookAndFeel());
		} catch (UnsupportedLookAndFeelException e) {}
		new Window();
	}

}
