package Calculadora;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Janela {
	private JTextField campoInsersao1, campoInsersao2, campoInsersao3, 
						campoInsersao4, campoInsersao5, campoInsersao6, campoInsersao7;

	public void criaJanela() {
		JFrame frame = new JFrame("Calculadora de Preço/Orçamento");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		URL iconURL = getClass().getResource("/Calculadora/imagens/iconeJanela.png");
        if (iconURL != null) {
        	ImageIcon icon = new ImageIcon(iconURL);
            Image image = icon.getImage(); 
            Image newImage = image.getScaledInstance(65, 65, Image.SCALE_SMOOTH); 
            icon = new ImageIcon(newImage); 
            frame.setIconImage(icon.getImage());
        } else {
            System.out.println("Erro ao carregar a imagem do ícone.");
        }		
		JPanel painel = new JPanel();
		painel.setLayout(new FlowLayout());
		
		JLabel label1 = new JLabel("<html>Valor de Custo<br>Produto/Peça");
		campoInsersao1 = new JTextField(5);
		JLabel label2 = new JLabel("<html>Quantidade Total<br> de Itens na Nota");
		campoInsersao2 = new JTextField(5);
		JLabel label3 = new JLabel("Valor frete ");
		campoInsersao3 = new JTextField(5);
		JLabel label4 = new JLabel("Margem de Lucro % ");
		campoInsersao4 = new JTextField(5);
		JLabel label5 = new JLabel("Imposto Produto % ");
		campoInsersao5 = new JTextField(5);
		JLabel label6 = new JLabel("Mão de Obra ");
		campoInsersao6 = new JTextField(5);
		JLabel label7 = new JLabel("Imposto Mão de Obra % ");
		campoInsersao7 = new JTextField(5);
		
		JButton btnCalcular = new JButton("Calcular Preço/Orçamento");
		btnCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
						DecimalFormat df = new DecimalFormat("0.00");
						double valorCusto = Double.parseDouble(campoInsersao1.getText());						
						double quantidade = Double.parseDouble(campoInsersao2.getText());
						double valorFrete = Double.parseDouble(campoInsersao3.getText());					
						double margemLucro = Double.parseDouble(campoInsersao4.getText());
						double imposto = Double.parseDouble(campoInsersao5.getText());
						double maoObra = Double.parseDouble(campoInsersao6.getText());
						double impostoMaoObra = Double.parseDouble(campoInsersao7.getText());
						Calculo calculo = new Calculo(valorCusto, quantidade,valorFrete,margemLucro,imposto, maoObra,impostoMaoObra);
						double resultado = calculo.calculaPreco();
						String valorFormatado = df.format(resultado);
						
						JOptionPane.showMessageDialog(frame, "<html>Preço sujerido de Orçamento/Venda <br> R$ " + valorFormatado);
					
					}catch (NumberFormatException ex) {
	                    JOptionPane.showMessageDialog(frame, "Por favor, insira valores numéricos válidos em todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			);
		JButton btnNovo = new JButton("Novo Calculo");
		btnNovo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });
		
			painel.add(label1);
			painel.add(campoInsersao1);
			painel.add(label2);
			painel.add(campoInsersao2);
			painel.add(label3);
			painel.add(campoInsersao3);
			painel.add(label4);
			painel.add(campoInsersao4);
			painel.add(label5);
			painel.add(campoInsersao5);
			painel.add(label6);
			painel.add(campoInsersao6);
			painel.add(label7);
			painel.add(campoInsersao7);
			painel.add(btnCalcular);
			painel.add(btnNovo);		
			frame.add(painel);
			frame.setSize(380, 200);
			frame.setVisible(true);
		
	}
	private void limparCampos() {
		if (campoInsersao1 != null)
            campoInsersao1.setText("");
        if (campoInsersao2 != null)
            campoInsersao2.setText("");
        if (campoInsersao3 != null)
            campoInsersao3.setText("");
        if (campoInsersao4 != null)
            campoInsersao4.setText("");
        if (campoInsersao5 != null)
            campoInsersao5.setText("");
        if (campoInsersao6 != null)
            campoInsersao6.setText("");
        if (campoInsersao7 != null)
        	campoInsersao7.setText("");
	
	}
}
	