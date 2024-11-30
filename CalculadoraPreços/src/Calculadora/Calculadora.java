package Calculadora;

public abstract class Calculadora {
	
		private double valorCustoProduto;
		private double valorFreteNota;
		private double quantidadeItensNota;
		private double imposto;
		private double margemLucro;
		private double maodeObra;
		private double impostoMdo;
		
		 


		public abstract double calculaPreco();

		public double getValorCustoProduto() {
			return valorCustoProduto;
		}

		public void setValorCustoProduto(double valorCustoProduto) {
			this.valorCustoProduto = valorCustoProduto;
		}
		public double getQuantidadeItensNota() {
			return quantidadeItensNota;
		}

		public void setQuantidadeItensNota(double quantidadeItensNota) {
			this.quantidadeItensNota = quantidadeItensNota;
		}
		
		public double getValorFreteNota() {
			return valorFreteNota;
		}
		public void setValorFreteNota(double valorFreteNota) {
			this.valorFreteNota = valorFreteNota;
			return;
			
		}
		
		public double getMargemLucro() {
			return margemLucro;
		}

		public void setMargemLucro(double margemLucro) {
			this.margemLucro = margemLucro;
		}
		
		public double getImposto() {
			return imposto;
			
		}
		public void setImposto(double imposto) {
			this.imposto = imposto;
			return;
			
		}

		public double getMaodeObra() {
			return maodeObra;
		}

		public void setMaodeObra(double maodeObra) {
			this.maodeObra = maodeObra;
		}

		

		public double getImpostoMdo() {
			return impostoMdo;
		}

		public void setImpostoMdo(double impostoMdo) {
			this.impostoMdo = impostoMdo;
		}
			
}