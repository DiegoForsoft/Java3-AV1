package br.com.projeto.java.av1.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.projeto.java.av1.entity.Carro;
import br.com.projeto.java.av1.enumeracoes.Cambio;
import br.com.projeto.java.av1.enumeracoes.Cor;
import br.com.projeto.java.av1.exception.AcessoIlegalBanco;
import br.com.projeto.java.av1.service.CarroService;

import com.google.gson.Gson;

@WebServlet("/AdicionarCarroServlet")
public class AdicionarCarroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdicionarCarroServlet() {
        super();
    }

    public void setConfiguracao(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
    	request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");
		response.setContentType("application/json");
    }
    
    public Carro recuperarDadosCarro(HttpServletRequest request) {
    	Carro c = new Carro();
    	
    	c.setChassi(request.getParameter("chassi"));
    	c.setMontadora(request.getParameter("montadora"));
    	c.setModelo(request.getParameter("modelo"));
    	c.setCambio(Cambio.valueOf(request.getParameter("tipoCarro")));
    	c.setCor(Cor.valueOf(request.getParameter("cor")));
    	c.setMotorizacao(Float.parseFloat(request.getParameter("motorizacao")));
    	c.setCambio(Cambio.valueOf(request.getParameter("cambio")));
    	c.setPreco(Float.parseFloat(request.getParameter("preco")));
    	
    	return c;
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	this.setConfiguracao(request, response);
		Gson gson = new Gson();
		CarroService servico = new CarroService();
		//Carro carro = recuperarDadosCarro(request);
		Carro c = gson.fromJson(request.getParameter("json"), Carro.class);
		
		try {
			servico.adicionarCarroNoBanco(c);
		} catch (SQLException | AcessoIlegalBanco e) {
			e.printStackTrace();
		}
    }
}
