package com.altercode;

import com.altercode.model.Categoria;
import com.altercode.model.UnidadeMedida;
import com.altercode.model.Produto;
import com.altercode.dao.ProdutoDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {

    ProdutoDAO dao = new ProdutoDAO();
    Produto produto = new Produto();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Application slc = new Application();
        int esc;
        System.out.println("\n\nMenu de Opções\n");

        while (true) {
            System.out.println("____________________________________________\n");
            System.out.println("Selecione uma das opções para adicionar...\n");
            System.out.println("1. Adicionar Produto\n2. Atualiazar Produto\n3. Deletar Produto\n4. Listar Produtos\n5. Buscar Produto por Id\n6. Buscar Produtos pela Categoria\n7. Buscar Produtos pela Medida\n8. Sair");
            System.out.println("Entre com a sua escolha: ");
            System.out.println("____________________________________________\n");
            esc = sc.nextInt();

            switch (esc) {
                case 1: {
                    slc.inserirProduto();
                    break;
                }
                case 2: {
                    slc.atualizarProduto();
                    break;
                }
                case 3: {
                    slc.deletarProduto();
                    break;
                }
                case 4: {
                    slc.listarProdutos();
                    break;
                }
                case 5: {
                    slc.buscarId();
                    break;
                }
                case 6: {
                    slc.buscarCategoria();
                    break;
                }
                case 7: {
                    slc.buscarMedida();
                    break;
                }
                case 8: {
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;
                }
                default: {
                    System.out.println("Por favor, selecione uma opção válida!");
                }
            }
        }
    }

    public void inserirProduto() {

        produto.setId(112L);
        produto.setDescricao("Arroz Carvalho 1 kg");
        produto.setQuantidade("70");
        produto.setPreco("4.70R$");
        produto.setValidade("11/1/2022");
        produto.setCategoria(Categoria.ALIMENTICIOS);
        produto.setMedida(UnidadeMedida.KILOGRAMA);

        System.out.println("Identificação: " + produto.getId());
        System.out.println("Descrição do Produto: " + produto.getDescricao());
        System.out.println("Quantidade Armazenada: " + produto.getQuantidade());
        System.out.println("Preço da Unidade: " + produto.getPreco());
        System.out.println("Data de Validade: " + produto.getValidade());
        System.out.println("Categoria: " + produto.getCategoria());
        System.out.println("Medida: " + produto.getMedida());
        System.out.println("\nProduto Adicionado!");

        dao.save(produto);
    }

    public void atualizarProduto() {
        Optional<Produto> produtoOptional = dao.findById(111L);
        Produto prod = produtoOptional.get();
        prod.setDescricao("Arroz Italianinho 1kg");
        prod.setQuantidade("97");
        prod.setPreco("3.80R$");
        prod.setValidade("31/12/9999");
        prod.setCategoria(Categoria.ALIMENTICIOS);
        prod.setMedida(UnidadeMedida.KILOGRAMA);

        System.out.println("Identificação: " + prod.getId());
        System.out.println("Descrição do Produto: " + prod.getDescricao());
        System.out.println("Quantidade Armazenada: " + prod.getQuantidade());
        System.out.println("Preço da Unidade: " + prod.getPreco());
        System.out.println("Data de Validade: " + prod.getValidade());
        System.out.println("Categoria: " + prod.getCategoria());
        System.out.println("Medida: " + prod.getMedida());
        System.out.println("\nProduto Alterado!");

        dao.update(prod);
    }

    public void deletarProduto() {
        dao.delete(1L);
        System.out.println("\nDespesa Deletada!");

    }

    public void listarProdutos(){
    }

    public void buscarId() {
        Optional<Produto> produtoOptional = dao.findById(1L);
        produtoOptional.ifPresent(prod -> {
            System.out.println("Identificação: " +prod.getId());
            System.out.println("Descrição do produto: " +prod.getDescricao());
            System.out.println("Quantidade armazenada: " +prod.getQuantidade());
            System.out.println("Preço: " +prod.getPreco());
            System.out.println("Data de validade: " +prod.getValidade());
            System.out.println("Categoria: " +prod.getCategoria());
            System.out.println("Unidade de medida: " +prod.getMedida());
        });
    }

    public void buscarCategoria() {
        List<Produto> produtos = dao.findByCat(Categoria.OUTROS);
        for (Produto prod: produtos) {

            System.out.println("Identificação: " + prod.getId());
            System.out.println("Descrição do produto: " + prod.getDescricao());
            System.out.println("Quantidade armazenada: " + prod.getQuantidade());
            System.out.println("Preço: " + prod.getPreco());
            System.out.println("Data de validade: " + prod.getValidade());
            System.out.println("Categoria: " + prod.getCategoria());
            System.out.println("Unidade de medida: " + prod.getMedida());
        }
    }

    public void buscarMedida() {
        List<Produto> produtos = dao.findByMed(UnidadeMedida.INDETERMINADO);
        for (Produto prod: produtos) {
            System.out.println("Identificação: " + prod.getId());
            System.out.println("Descrição do produto: " + prod.getDescricao());
            System.out.println("Quantidade armazenada: " + prod.getQuantidade());
            System.out.println("Preço: " + prod.getPreco());
            System.out.println("Data de validade: " + prod.getValidade());
            System.out.println("Categoria: " + prod.getCategoria());
            System.out.println("Unidade de medida: " + prod.getMedida());
        }
    }
}
