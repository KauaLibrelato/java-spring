package com.satc.satcloja.health;

import com.satc.satcloja.model.*;
import com.satc.satcloja.repository.ClienteRepository;
import com.satc.satcloja.repository.ProdutoRepository;
import com.satc.satcloja.repository.ServicoRepository;
import com.satc.satcloja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HealthCheckController {
    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public ServicoRepository servicoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public VendaRepository vendaRepository;
    @GetMapping("/teste")
    public String healthCheck2(){
        Produto produto = new Produto();

        produto.setDescricao ("Intel Pentium 15");
        produto.setNome("PC Intel");
        produto.setValorUnitario (1000.00);
        produto.setDataPrazo (LocalDate.now());
        produto.setDataValidade (LocalDate.now());
        produto.setPrecoCompra (850.00);
        produto.setStatus (Status.DISPONIVEL);
        produto.setEstocavel (Boolean. TRUE);
        produtoRepository.save(produto);


        Servico servico = new Servico();
        servico.setQuantidadeHoras(20.00);
        servico.setDescricao("Pacote office instalação.");
        servico.setEstocavel(Boolean.TRUE);
        servico.setValorUnitario(150.00);
        servicoRepository.save(servico);

        Cliente cliente = new Cliente();
        cliente.setCpf("40028922");
        cliente.setRg("1212121");
        cliente.setNome("kauã");
        cliente.setEmail("kaua@email.com");
        cliente.setEndereco("Rua jairo nunes");
        cliente.setTelefone("99999999");
        clienteRepository.save(cliente);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(LocalDate.now());
        venda.setObservacao("Teste");
        venda.setFormaPagamento(FormaPagamento.DINHEIRO);

        ItemVenda itemVenda = new ItemVenda(produto, 1000.0, 1.0, 10.00);
        ItemVenda itemVenda2 = new ItemVenda(servico, 100.0, 1.0, 10.00);

        venda.addItemVenda(itemVenda);
        venda.addItemVenda(itemVenda2);
        vendaRepository.save(venda);
        return "Comando Executado!" ;
    }



}
