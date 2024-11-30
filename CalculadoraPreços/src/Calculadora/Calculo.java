package Calculadora;

import javax.swing.JOptionPane;

public class Calculo extends Calculadora{
	


	public Calculo(double valorCustoProduto,
					double quantidadeItensNota,
					double valorFreteNota,  
					double margemLucro,
					double imposto,
					double maodeObra, 
					double impostoMdo) {
        this.setValorCustoProduto(valorCustoProduto);
        this.setQuantidadeItensNota(quantidadeItensNota);
        this.setValorFreteNota(valorFreteNota);
        this.setMargemLucro(margemLucro);
        this.setImposto(imposto);       
        this.setMaodeObra(maodeObra);
        this.setImpostoMdo(impostoMdo);
        
	}     
        public double calculaPreco() {
            boolean podeCalcular = true;  
            double calculoImpostoMdo = 0;
            double calculoImposto = 0;
            double calculoMargem = 0;
            double freteUnitario = 0;
            double custoTotalUnitario = 0;
            double valorFinalMdo = 0;
            double valorComMargem;
            double valorSugerido;

            try {
                if (getImpostoMdo() > 0) {
                    calculoImpostoMdo = getImpostoMdo() / 100;
                }else if(getImpostoMdo() == 0){
                	calculoImpostoMdo = 0;
                }
                
                else {
                    JOptionPane.showMessageDialog(null, "Erro Imposto Negativo");
                    podeCalcular = false;
                }

                if (getImposto() > 0) {
                    calculoImposto = getImposto() / 100;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro Imposto Negativo ou Zero");
                    podeCalcular = false;
                }

                if (getMargemLucro() > 0) {
                    calculoMargem = getMargemLucro() / 100;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro Numero Negativo ou Zero");
                    podeCalcular = false;
                }

                if (getQuantidadeItensNota() > 0 && getValorFreteNota() > 0) {
                    freteUnitario = getValorFreteNota() / getQuantidadeItensNota();
                
                } else if (getQuantidadeItensNota() <= 0) {
                    JOptionPane.showMessageDialog(null, "<html>Atenção <br> Nota sem itens ?");
                    setQuantidadeItensNota(1);
                    podeCalcular = false;                    
                } else if (getValorFreteNota() > 0) {
                    freteUnitario = getValorFreteNota();
                } else {
                    freteUnitario = 0;
                    JOptionPane.showMessageDialog(null, "<html>Atenção <br> Nota sem frete !!");
                    
                }

                if (getValorCustoProduto() > 0) {
                    custoTotalUnitario = getValorCustoProduto() + freteUnitario;
                } else {
                    JOptionPane.showMessageDialog(null, "Erro Custo não pode ser Zero");
                    podeCalcular = false;
                }

                if (getMaodeObra() > 0) {
                    valorFinalMdo = getMaodeObra() + (getMaodeObra() * calculoImpostoMdo);
                }else if(getMaodeObra() == 0) {
                	valorFinalMdo = 0;
                }
                
                else {
                    JOptionPane.showMessageDialog(null, "Erro mão de obra não pode ser negativo");
                    podeCalcular = false;
                }

                if (podeCalcular) {  // Executa o cálculo apenas se nenhum erro foi detectado
                    valorComMargem = custoTotalUnitario + (calculoMargem * custoTotalUnitario);
                    valorSugerido = valorComMargem + (valorComMargem * calculoImposto) + valorFinalMdo;

                    return valorSugerido;
                } else {
                    return 0; 
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
                return 0;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro inesperado: " + e.getMessage());
                return 0;
            }
        }
}