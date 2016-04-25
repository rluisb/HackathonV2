package com.stefanini.hackathon2.servicos;

import java.time.DayOfWeek;
import java.time.LocalDate;

import javax.inject.Inject;

import com.stefanini.hackathon2.entidades.Emprestimo;
import com.stefanini.hackathon2.entidades.Livro;
import com.stefanini.hackathon2.repositorios.EmprestimoRepositorio;
import com.stefanini.hackathon2.transacao.Transacional;

public class EmprestimoServico extends ServicoAbstrato<Emprestimo>{
	
	private int qtdeNova;
	@Inject
	public EmprestimoServico(EmprestimoRepositorio repositorio) {
		super(Emprestimo.class, repositorio);
	}
	
	
	@Transacional
	public int calcIntervaloDias(LocalDate inicio, LocalDate fim) {
		LocalDate diaDaSemana = inicio;
		Integer qtdDias = 0;

		if(fim == null) {
			fim = LocalDate.now();
		}
		
		while(diaDaSemana.isBefore(fim)) {
			if(diaDaSemana.getDayOfWeek() == DayOfWeek.FRIDAY) {
				diaDaSemana = diaDaSemana.plusDays(3);
			} else {
				diaDaSemana = diaDaSemana.plusDays(1);
			}
			qtdDias++;
		}
		return qtdDias <= 7 ? 0 : qtdDias - 7;
	}
	
	@Transacional
	public boolean emprestaLivro(Emprestimo emprestimo) {
		for (Livro livroAtual : emprestimo.getLivros()) {
			if(livroEstaDisponivel(emprestimo)){
				livroAtual.setQtdeEmprestado(livroAtual.getQtdeEmprestado() + 1);
				salvar(emprestimo);
				if(livroEstaDisponivel(emprestimo)){
					livroAtual.setStatus("Disponivel");
					emprestimo.setStatus("Em andamento");
				}
			}
		}
		return false;
	}
	
	@Transacional
	public boolean devolveLivro(Emprestimo emprestimo) {
		for (Livro livroAtual : emprestimo.getLivros()) {
			if(livroEstaDisponivel(emprestimo)){
				qtdeNova = livroAtual.getQtdeEmprestado() - 1;
				livroAtual.setQtdeEmprestado(qtdeNova);
				salvar(emprestimo);
				if(livroEstaDisponivel(emprestimo)){
					livroAtual.setStatus("Disponivel");
					emprestimo.setStatus("Finalizado");
				}
			}
		}
		return false;
	}
	
	@Transacional
	public boolean livroEstaDisponivel(Emprestimo emprestimo) {
		for (Livro livroAtual : emprestimo.getLivros()) {
			if(livroAtual.getQtdeEstoque() == null){
				livroAtual.setQtdeEstoque(0);
			}
			
			if(livroAtual.getQtdeEmprestado() == null){
				livroAtual.setQtdeEmprestado(0);
			}
			
			if(livroAtual.getQtdeEstoque() > livroAtual.getQtdeEmprestado()){
				return true;
			}
		}
		return false;
	}
}
